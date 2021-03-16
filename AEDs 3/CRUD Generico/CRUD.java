import java.io.*;
import java.lang.reflect.*;

public class CRUD <T extends Registro> 
{
    
    RandomAccessFile arq;
    Constructor<T> construtor;
    String arq_name;

    //Abertura e fechamento

    public CRUD(Constructor<T> c, String nameArq) throws FileNotFoundException
    {
        this.arq_name = nameArq;
        arq = new RandomAccessFile(nameArq, "rw");
        this.construtor = c;
    }

    public boolean end()
    {
        boolean conseguiu = false;
        try
        {
            arq.close();
            conseguiu = true;
        }
        catch (IOException erro)
        {
            erro.printStackTrace();
        }
        return conseguiu;
    }

    //CRUD

    public int create(T obj)
    {
        try
        {
            arq.seek(0);
            if (arq.read() == -1)
                arq.writeInt(-1);
            arq.seek(0);
            int last_id = arq.readInt();
            if (last_id < -1)
                throw new IOException("Ultimo id nao encontrado");
            obj.setId(++last_id);
            arq.seek(0);
            arq.writeInt(obj.getId());
            arq.seek(arq.length());
            newRegister(obj);
        }
        catch (IOException erro)
        {
            erro.printStackTrace();
        }
        return obj.getId();
    }

    public T read(int id) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        T obj_return= construtor.newInstance();
        try
        {
            arq.seek(4);
            long tamarq = arq.length();
            while (arq.getFilePointer() < tamarq)
            {
                boolean not_lapide = notLapide();
                int tamRegistro = arq.readInt();
                if (not_lapide)
                {
                    byte[] obj = new byte[tamRegistro];
                    arq.read(obj);
                    obj_return.fromByteArray(obj);
                    if (obj_return.getId() == id)
                        return obj_return;
                    else
                        obj_return = construtor.newInstance();
                }
                else
                    arq.seek(arq.getFilePointer() + tamRegistro);
            }
            return obj_return;
        }
        catch(Exception erro)
        {
            erro.printStackTrace();
        }
        return obj_return;
    }

    public boolean update(T new_obj)
    {
        boolean success = false;
        try
        {
            arq.seek(4);
            long tamarq = arq.length();
            long pos = arq.getFilePointer();
            while (pos <= tamarq)
            {
                boolean not_lapide = notLapide();
                int tamRegistro = arq.readInt();
                if (not_lapide)
                {
                    byte[] obj_byte = new byte[tamRegistro];
                    arq.read(obj_byte);
                    T obj = construtor.newInstance();
                    obj.fromByteArray(obj_byte);
                    if (obj.getId() == new_obj.getId())
                    {
                        arq.seek(pos);
                        int tam_new_obj = new_obj.toByteArray().length;
                        if (tam_new_obj <= obj_byte.length)
                        {
                            new_obj.setId(obj.getId());
                            //para manter o mesmo tamanho do registro devemos passar ele como parametro
                            success = newRegister(new_obj, tamRegistro);
                        }
                        else
                        {
                            arq.writeChar('*');
                            arq.seek(arq.length());
                            success = newRegister(new_obj);
                        }
                        return success;
                    }
                }
                pos = arq.getFilePointer();
            }
        }
        catch (Exception erro)
        {
            erro.printStackTrace();
        }
        return success;
    }

    public boolean delete(int id)
    {
        boolean success = false;
        try
        {
            arq.seek(4);
            long pos = arq.getFilePointer();
            while(pos <= arq.length())
            {
                boolean not_lapide = notLapide();
                int tamRegistro = arq.readInt();
                if (not_lapide && arq.readInt() == id)
                {
                    arq.seek(pos);
                    arq.writeChar('*');
                    return success = true;
                }
                else
                    // + 6 da lapide e do int do tamanho do registro
                    arq.seek(pos + tamRegistro + 6);
                pos = arq.getFilePointer();
            }
        }
        catch (IOException erro)
        {
            erro.printStackTrace();
        }
        return success;
    }

    //Funcoes essenciais

    public boolean newRegister(T obj)
    {
        boolean success = false;
        try
        {
            arq.writeChar(' ');
            byte[] obj_byte = obj.toByteArray();
            arq.writeInt(obj_byte.length);
            arq.write(obj_byte);
            success = true;
        }
        catch (IOException erro)
        {
            erro.printStackTrace();
        }
        return success;
    }

    public boolean newRegister(T obj,int tam)
    {
        boolean success = false;
        try
        {
            arq.writeChar(' ');
            byte[] obj_byte = obj.toByteArray();
            arq.writeInt(tam);
            arq.write(obj_byte);
            success = true;
        }
        catch (IOException erro)
        {
            erro.printStackTrace();
        }
        return success;
    }

    public boolean notLapide() throws IOException
    {
        return (arq.readChar() != '*');
    }
}
