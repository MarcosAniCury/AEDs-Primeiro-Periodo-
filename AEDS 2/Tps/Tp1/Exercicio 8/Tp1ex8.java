import java.net.*;
import java.io.*;

class Contador
{
    public static int a = 0;
    public static int e = 0;
    public static int i = 0;
    public static int o = 0;
    public static int u = 0;
    public static int aesq = 0;
    public static int eesq = 0;
    public static int iesq = 0;
    public static int oesq = 0;
    public static int uesq = 0;
    public static int adir = 0;
    public static int edir = 0;
    public static int idir = 0;
    public static int odir = 0;
    public static int udir = 0;
    public static int atiu = 0;
    public static int otiu = 0; 
    public static int acir = 0;
    public static int ecir = 0;
    public static int icir = 0;
    public static int ocir = 0;
    public static int ucir = 0;
    public static int consoante = 0;
    public static int br = 0;
    public static int table = 0;
    public static int nomedapag = 0;

    public Contador() {}
}

public class Tp1ex8
{
    public static boolean isFim(String palavra)
    {
        return (palavra.length() == 3 && palavra.charAt(0) == 'F' && palavra.charAt(1) == 'I' && palavra.charAt(2) == 'M');
    }

    public static boolean isConsoante(char palavra)
    {
        boolean resp = true;
        if ((palavra == 'a' || palavra == 'e' || palavra == 'i' || palavra == 'o' || palavra == 'u') || !(palavra >= 'a' && palavra <= 'z'))
            resp = false;
        return resp;
    }

    public static String LeituraPag(String pagurl)
    {
        String conteudodapag = "";
        InputStream site = null;
        try
        {
            URL url = new URL(pagurl);
            site = url.openStream();
            BufferedReader entrada = new BufferedReader(new InputStreamReader(site));
            String temp = "";
            
            while((temp = entrada.readLine()) != null)
                conteudodapag += temp;
        }
        catch (MalformedURLException mue) 
        {
            mue.printStackTrace();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
        
        try 
        {
            site.close();
        }
        catch (IOException ioe) 
        {
            // nothing to see here
        }
        return conteudodapag;
    }

    public static boolean isBr(String contepag, int cont)
    {
        boolean resp = false;
        if((contepag.charAt(cont) == '<') && (contepag.charAt(cont + 1) == 'b') && (contepag.charAt(cont + 2) == 'r') && (contepag.charAt(cont + 3) == '>'))
            resp = true;
        return resp;
    }

    public static boolean isTable(String contepag, int cont)
    {
        boolean resp = false;
        if ((contepag.charAt(cont) == '<') && (contepag.charAt(cont + 1) == 't') && (contepag.charAt(cont + 2) == 'a') && (contepag.charAt(cont + 3) == 'b') && (contepag.charAt(cont + 4) == 'l') && (contepag.charAt(cont + 5) == 'e') && (contepag.charAt(cont + 6) == '>'))
            resp = true;
        return resp;
    }

    public static boolean isNomepag(String contepag, int cont, String nomepag)
    {
        boolean resp = false;
        for (int i = 0; i < nomepag.length() && cont < contepag.length();i++, cont++)
        {
            if (contepag.charAt(cont) == nomepag.charAt(i))
            resp = true;
        }
        return resp;
    }

    public static void main(String [] args) throws Exception
    {
	MyIO.setCharset("ISO-8859-1");
        String[] nome = new String[1000];
        String[] pag = new String[1000];
        int npag = 0;
        Contador[] valores = new Contador[1000];
        do
        {
            nome[npag] = MyIO.readLine();
            if (!isFim(nome[npag]))
                pag[npag] = MyIO.readLine();
        }while (!isFim(nome[npag++]));
        npag--;

        for (int i = 0; i < npag;i++)
        {
            String contepag = LeituraPag(pag[i]);
            for (int j = 0; j < contepag.length();j++)
            {
                if (contepag.charAt(j) == 'a')
                    valores[i].a++;
                if (contepag.charAt(j) == 'e')
                    valores[i].e++;
                if (contepag.charAt(j) == 'i')
                    valores[i].i++;
                if (contepag.charAt(j) == 'o')
                    valores[i].o++;
                if (contepag.charAt(j) == 'u')
                    valores[i].u++;
                if (contepag.charAt(j) == 'à')
                    valores[i].aesq++;
                if (contepag.charAt(j) == 'è')
                    valores[i].eesq++;
                if (contepag.charAt(j) == 'ì')
                    valores[i].iesq++;
                if (contepag.charAt(j) == 'ò')
                    valores[i].oesq++;
                if (contepag.charAt(j) == 'ù')
                    valores[i].uesq++;
                if (contepag.charAt(j) == 'á')
                    valores[i].adir++;
                if (contepag.charAt(j) == 'é')
                    valores[i].edir++;
                if (contepag.charAt(j) == 'í')
                    valores[i].idir++;
                if (contepag.charAt(j) == 'ó')
                    valores[i].odir++;
                if (contepag.charAt(j) == 'ú')
                    valores[i].udir++;
                if (contepag.charAt(j) == 'ã')
                    valores[i].atiu++;
                if (contepag.charAt(j) == 'õ')
                    valores[i].otiu++;
                if (contepag.charAt(j) == 'â')
                    valores[i].acir++;
                if (contepag.charAt(j) == 'ê')
                    valores[i].ecir++;
                if (contepag.charAt(j) == 'î')
                    valores[i].icir++;
                if (contepag.charAt(j) == 'ô')
                    valores[i].ocir++;
                if (contepag.charAt(j) == 'û')
                    valores[i].ucir++;
                if (isConsoante(contepag.charAt(j)))
                    valores[i].consoante++;
                if (isBr(contepag, j))
                    valores[i].br++;
                if (isTable(contepag, j))
                    valores[i].table++;
                if (isNomepag(contepag, j, nome[i]))
                    valores[i].nomedapag++;
            }
            MyIO.print("a("+valores[i].a+") ");
            MyIO.print("e("+valores[i].e+") ");
            MyIO.print("i("+valores[i].i+") ");
            MyIO.print("o("+valores[i].o+") ");
            MyIO.print("u("+valores[i].u+") ");
            MyIO.print(new String(("á("+valores[i].adir+") ").getBytes(), "ISO-8859-1"));
            MyIO.print(new String(("é("+valores[i].edir+") ").getBytes(), "ISO-8859-1"));
            MyIO.print(new String(("í("+valores[i].idir+") ").getBytes(), "ISO-8859-1"));
            MyIO.print(new String(("ó("+valores[i].odir+") ").getBytes(), "ISO-8859-1"));
            MyIO.print(new String(("ú("+valores[i].udir+") ").getBytes(), "ISO-8859-1"));
            MyIO.print(new String(("à("+valores[i].aesq+") ").getBytes(), "ISO-8859-1"));
            MyIO.print(new String(("è("+valores[i].eesq+") ").getBytes(), "ISO-8859-1"));
            MyIO.print(new String(("ì("+valores[i].iesq+") ").getBytes(), "ISO-8859-1"));
            MyIO.print(new String(("ò("+valores[i].oesq+") ").getBytes(), "ISO-8859-1"));
            MyIO.print(new String(("ù("+valores[i].uesq+") ").getBytes(), "ISO-8859-1"));
            MyIO.print(new String(("ã("+valores[i].atiu+") ").getBytes(), "ISO-8859-1"));
            MyIO.print(new String(("õ("+valores[i].otiu+") ").getBytes(), "ISO-8859-1"));
            MyIO.print(new String(("â("+valores[i].acir+") ").getBytes(), "ISO-8859-1"));
            MyIO.print(new String(("ê("+valores[i].ecir+") ").getBytes(), "ISO-8859-1"));
            MyIO.print(new String(("î("+valores[i].icir+") ").getBytes(), "ISO-8859-1"));
            MyIO.print(new String(("ô("+valores[i].ocir+") ").getBytes(), "ISO-8859-1"));
            MyIO.print(new String(("û("+valores[i].ucir+") ").getBytes(), "ISO-8859-1"));
            MyIO.print("consoante("+valores[i].consoante+") ");
            MyIO.print("<br>("+valores[i].br+") ");
            MyIO.print("<table>("+valores[i].table+") ");
            MyIO.println(nome[i]);
        }
    }
}
