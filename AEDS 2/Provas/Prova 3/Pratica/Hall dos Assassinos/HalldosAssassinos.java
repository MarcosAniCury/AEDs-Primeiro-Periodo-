class Murder
{
    private String nome;
    public boolean morto;
    public int mortes;

    public Murder()
    {
        nome = "";
        morto = false;
        mortes = 0;
    }

    public Murder(String nome)
    {
        this.nome = nome;
        morto = false;
        mortes = 0;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }
}

class Vitimas
{
    private String nome;

    public Vitimas()
    {
        nome = "";
    }

    public Vitimas(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }
}

public class HalldosAssassinos
{
    public static void main(String [] args)
    {
        int contentrada = 0;
        String[] entrada = new String[1000];
        do
        {
            entrada[contentrada] = MyIO.readLine();
        }while(!entrada[contentrada++].equals("FIM"));
        contentrada--;
        int contassassinos = 0;
        int contvitimas = 0;
        //cria e atribui valores aos assassinos e as vitimas
        Murder[] assassinos = new Murder[contentrada];
        Vitimas[] vitimas = new Vitimas[contentrada];
        for(int i = 0;i < contentrada;i++)
        {
            String[] aux = entrada[i].split(" ");
            assassinos[contassassinos++] = new Murder(aux[0]);
            vitimas[contvitimas++] = new Vitimas(aux[1]);
        }

        //verifica se ele é morto
        for(int i = 0;i < contassassinos;i++)
        {
            for(int j = 0;j < contvitimas;j++)
            {
                if(assassinos[i].getNome().equals(vitimas[j].getNome()))
                    assassinos[i].morto = true;
            }
        }

        for(int i = 0;i < contassassinos;i++)
        {
            if(!assassinos[i].morto)
            {
                assassinos[i].mortes++;
                for(int j = i-1;j >= 0;j--)
                {
                    if(assassinos[i].getNome().equals(assassinos[j].getNome()) && !assassinos[j].morto)
                    {
                        assassinos[j].mortes += assassinos[i].mortes;
                        assassinos[i].morto = true;
                    }
                }
            }
        }

        MyIO.println("HALL OF MURDERERS");
        for (int j = 0;j < contassassinos;j++)
        {
            if(!assassinos[j].morto)
            {
                MyIO.println(assassinos[j].getNome()+" "+assassinos[j].mortes);
            }
        }
    }
}
