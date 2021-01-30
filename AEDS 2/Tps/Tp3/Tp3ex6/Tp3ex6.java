import java.io.*;

class Celula
{
    public Jogador conteudo;
    public Celula prox;

    public Celula() {}
    
    public Celula(Celula prox)
    {
        this.prox = prox;
    }

    public Celula(Jogador conteudo)
    {
        this.conteudo = conteudo.clone();
        this.prox = null;
    }

    public Celula(Jogador conteudo, Celula prox)
    {
        this.prox = prox;
        this.conteudo = conteudo;
    }

    public Celula clone()
    {
        Celula clone = new Celula();
        clone.conteudo = this.conteudo;
        if (prox != null)
            clone.prox = this.prox.clone();
        else
            clone.prox = null;
        return clone;
    }
}

class PilhaDinamica
{
    private Celula Inicio;

    public PilhaDinamica() {Inicio = new Celula();}

    public PilhaDinamica(Celula comeco)
    {
        Inicio = comeco;
    }

    public void inserir (Jogador novo)
    {
        Celula tmp = new Celula(novo);
        tmp.prox = Inicio;
        Inicio = tmp;
        tmp = null;
    }

    public Jogador remover()
    {
        Jogador retorno = Inicio.conteudo;
        Celula tmp = Inicio;
        Inicio = Inicio.prox;
        tmp = tmp.prox = null;
        return retorno;
    }

    public int tamanho()
    {
        int tamanho = 0;
        for(Celula i = Inicio;i.prox != null; i = i.prox,tamanho++);
        return tamanho;
    }

    public void MostrarPilha(boolean notRemovidos)
    {
        if (notRemovidos)
            MostrarPilha(Inicio, tamanho()-1);
        else
            MostrarPilha(Inicio);
    }

    public void MostrarPilha(Celula i)
    {
        if (i.prox != null)
        {
            MostrarPilha(i.prox);
            MyIO.println("(R) "+i.conteudo.Getnome());
        }
    }

    public void MostrarPilha(Celula i, int j)
    {
        if(i.prox != null)
        {
            MostrarPilha(i.prox, j - 1);
            MyIO.print("["+j+"]");
            i.conteudo.Imprimir();
        }
    }
}

class Jogador
{
    private int id;
    private String nome;
    private int altura;
    private int peso;
    private String universidade;
    private int anoNascimento;
    private String cidadeNascimento;
    private String estadoNascimento;

    public Jogador() {}

    public Jogador(int idjogador)
    {
        Setid(idjogador);
    }

    //SETS
    
    public void Setid(int id)
    {
        this.id = id;
    }

    public void Setnome(String nome)
    {
        this.nome = nome;
    }

    public void Setaltura(int altura)
    {
        this.altura = altura;
    }

    public void Setpeso(int peso)
    {
        this.peso = peso;
    }

    public void Setuniversidade(String universidade)
    {
        this.universidade = universidade;
    }

    public void SetanoNascimento(int anoNascimento)
    {
        this.anoNascimento = anoNascimento;
    }

    public void SetcidadeNascimento(String cidadeNascimento)
    {
        this.cidadeNascimento = cidadeNascimento;
    }

    public void SetestadoNascimento(String estadoNascimento)
    {
        this.estadoNascimento = estadoNascimento;
    }

    //GETS

    public int Getid()
    {
        return this.id;
    }

    public String Getnome()
    {
        return this.nome;
    }

    public int Getaltura()
    {
        return this.altura;
    }

    public int Getpeso()
    {
        return this.peso;
    }

    public String Getuniversidade()
    {
        return this.universidade;
    }

    public int GetanoNascimento()
    {
        return this.anoNascimento;
    }

    public String GetcidadeNascimento()
    {
        return this.cidadeNascimento;
    }

    public String GetestadoNascimento()
    {
        return this.estadoNascimento;
    }

    //Ler

    public void Lerid()
    {
        MyIO.print(this.id);
    }

    public void Lernome()
    {
        MyIO.print(this.nome);
    }

    public void Leraltura()
    {
        MyIO.print(this.altura);
    }

    public void Lerpeso()
    {
        MyIO.print(this.peso);
    }

    public void Leruniversidade()
    {
        MyIO.print(this.universidade);
    }

    public void LeranoNascimento()
    {
        MyIO.print(this.anoNascimento);
    }

    public void LercidadeNascimento()
    {
        MyIO.print(this.cidadeNascimento);
    }

    public void LerestadoNascimento()
    {
        MyIO.print(this.estadoNascimento);
    }

    public void Imprimir()
    {
        MyIO.print(" ## ");
        Lernome();
        MyIO.print(" ## ");
        Leraltura();
        MyIO.print(" ## ");
        Lerpeso();
        MyIO.print(" ## ");
        LeranoNascimento();
        MyIO.print(" ## ");
        Leruniversidade();
        MyIO.print(" ## ");
        LercidadeNascimento();
        MyIO.print(" ## ");
        LerestadoNascimento();
        MyIO.println(" ##");
    }

    public Jogador clone()
    {
        Jogador copia = new Jogador();
        copia.Setid(this.id);
        copia.Setnome(this.nome);
        copia.Setaltura(this.altura);
        copia.Setpeso(this.peso);
        copia.Setuniversidade(this.universidade);
        copia.SetanoNascimento(this.anoNascimento);
        copia.SetcidadeNascimento(this.cidadeNascimento);
        copia.SetestadoNascimento(this.estadoNascimento);
        return copia;
    }
}

public class Tp3ex6
{

    public static String endereco = "/tmp/players.csv";

    public static void ManipulacaoPilha(PilhaDinamica Inicial, PilhaDinamica Removidos, String[] entrada)
    {
        for (int i = 0;i < entrada.length;i++)
        {
            Jogador temp = new Jogador();
            String operacao = entrada[i].substring(0, 1);
            if (operacao.compareTo("I") == 0)
            {
                leitura(endereco, temp, Integer.parseInt(entrada[i].substring(2, entrada[i].length())));
                Inicial.inserir(temp);
                temp = null;
            }
            else
                Removidos.inserir(Inicial.remover());
        }
    }

    //ler apenas um jogador
    public static void leitura(String link, Jogador armazenando, int numero)
    {
        try
        {
            //abertura do players.csv
            FileReader arquivo = new FileReader(link);
            BufferedReader larquivo = new BufferedReader(arquivo);
            //pegar de linha em linha pulando a primeira linha do arquivo
            String linha = larquivo.readLine();
            //enviar string por string para a Armazena, manipular e armazenar
            boolean armazenado = false;
            //armazena os ids de forma ordenada no vetor
            String id = "";
            do
            {
                //verificar se o id da linha e um dos ids selecionados na entrada
                linha = larquivo.readLine();
                id = linha.substring(0,linha.indexOf(","));
                if(numero == Integer.parseInt(id))
                {
                    Armazena(linha, armazenando);
                    armazenado = true;
                }
            }while(!armazenado);
            larquivo.close();
            arquivo.close();
        }
        catch(IOException ex)
        {
            System.err.printf("Nao foi possivel continuar essa acao");
            ex.getMessage();
        }
    }

    //ler diversos jogadores e armazenar em uma Pilha
    public static void leitura(String link, PilhaDinamica Inicial, String[] entrada, int nentrada)
    {
        try
        {
            int n = 0;
            do
            {
                //abertura do players.csv
                FileReader arquivo = new FileReader(link);
                BufferedReader larquivo = new BufferedReader(arquivo);
                //pegar de linha em linha pulando a primeira linha do arquivo
                String linha = larquivo.readLine();
                //enviar string por string para a Armazena, manipular e armazenar
                boolean armazenado = false;
                //armazena os ids de forma ordenada no vetor
                String id = "";
                do
                {
                    //verificar se o id da linha e um dos ids selecionados na entrada
                    linha = larquivo.readLine();
                    id = linha.substring(0,linha.indexOf(","));
                    if(entrada[n].equals(id))
                    {
                        Armazena(linha, Inicial);
                        armazenado = true;
                    }
                }while(Integer.parseInt(entrada[n]) > Integer.parseInt(id) && !armazenado);
                n++;
                larquivo.close();
                arquivo.close();
            }while (Inicial.tamanho() != nentrada && n != nentrada);
        }
        catch(IOException ex)
        {
            System.err.printf("Nao foi possivel continuar essa acao");
            ex.getMessage();
        }
    }

    //armazenar apenas um jogador  
    public static void Armazena(String valores, Jogador armazenando)
    {
        String[] aux = new String[8];
        String[] aux2 = new String[8];
        //Dividir a String em aux2 aonde tem virgula
        aux2 = valores.split(",");
        for (int i = 0;i < 8;aux[i++] = "");
        //atribuir a aux o vetor aux2 sendo que quando o campo esta vazio se mantem o valor atribuido anterior mente a aux
        for (int i = 0;i < aux2.length;aux[i] = aux2[i++]);
        //armazenamento dos valores em armazenando
        armazenando.Setid(Integer.parseInt(aux[0]));
        if (aux[1].equals(""))
            armazenando.Setnome("nao informado");
        else
            armazenando.Setnome(aux[1]);
        armazenando.Setaltura(Integer.parseInt(aux[2]));
        armazenando.Setpeso(Integer.parseInt(aux[3]));
        if (aux[4].equals(""))
            armazenando.Setuniversidade("nao informado");
        else    
            armazenando.Setuniversidade(aux[4]);
        armazenando.SetanoNascimento(Integer.parseInt(aux[5]));
        if (aux[6].equals(""))
            armazenando.SetcidadeNascimento("nao informado");
        else
            armazenando.SetcidadeNascimento(aux[6]);
        if (aux[7].equals(""))
            armazenando.SetestadoNascimento("nao informado");
        else
            armazenando.SetestadoNascimento(aux[7]);
    }

    //armazenar jogadores em uma pilha
    public static void Armazena(String valores, PilhaDinamica Inicial)
    {
        String[] aux = new String[8];
        String[] aux2 = new String[8];
        //Dividir a String em aux2 aonde tem virgula
        aux2 = valores.split(",");
        for (int i = 0;i < 8;aux[i++] = "");
        //atribuir a aux o vetor aux2 sendo que quando o campo esta vazio se mantem o valor atribuido anterior mente a aux
        for (int i = 0;i < aux2.length;aux[i] = aux2[i++]);
        Jogador jogadortemp = new Jogador();
        //armazenamento dos valores em jogadortemp
        jogadortemp.Setid(Integer.parseInt(aux[0]));
        if (aux[1].equals(""))
            jogadortemp.Setnome("nao informado");
        else
            jogadortemp.Setnome(aux[1]);
        jogadortemp.Setaltura(Integer.parseInt(aux[2]));
        jogadortemp.Setpeso(Integer.parseInt(aux[3]));
        if (aux[4].equals(""))
            jogadortemp.Setuniversidade("nao informado");
        else    
            jogadortemp.Setuniversidade(aux[4]);
        jogadortemp.SetanoNascimento(Integer.parseInt(aux[5]));
        if (aux[6].equals(""))
            jogadortemp.SetcidadeNascimento("nao informado");
        else
            jogadortemp.SetcidadeNascimento(aux[6]);
        if (aux[7].equals(""))
            jogadortemp.SetestadoNascimento("nao informado");
        else
            jogadortemp.SetestadoNascimento(aux[7]);
        Inicial.inserir(jogadortemp);
        jogadortemp = null;
    }

    public static boolean isFim(String entrada)
    {
        boolean resp = false;
        if (entrada.equals("FIM"))
            resp = true;
        return resp;
    } 

    public static void main(String [] args)
    {
        //entrada dos ids a serem lidos
        String[] entrada = new String[4000];
        int Nentrada = 0;
        do
        {
            entrada[Nentrada] = MyIO.readLine();
        }while(!isFim(entrada[Nentrada++]));
        Nentrada--;

        int Nentradas2 = MyIO.readInt();
        String[] entrada2 = new String[Nentradas2];
        for (int i = 0;i < Nentradas2;i++)
            entrada2[i] = MyIO.readLine();

        PilhaDinamica Inicial = new PilhaDinamica();
        PilhaDinamica Removidos = new PilhaDinamica();

        leitura(endereco, Inicial, entrada, Nentrada);

        ManipulacaoPilha(Inicial, Removidos, entrada2);

        Removidos.MostrarPilha(false);
        Inicial.MostrarPilha(true);
    }
}