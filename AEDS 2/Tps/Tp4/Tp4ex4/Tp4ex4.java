import java.io.*;

class No
{
    public Jogador elemento;
    public No esq,dir;
    public boolean cor;

    public No() {esq = dir = null;}

    public No(Jogador elemento)
    {
        this.elemento = elemento;
    }

    public No(Jogador elemento, boolean cor)
    {
        this.elemento = elemento;
        this.cor = cor;
    }
}

class ArvoreBinaria
{
    private No raiz;
    private int n;

    public ArvoreBinaria() 
    {
        raiz = null;
        n = 0;
    }

    public void inserir(Jogador elemento) throws Exception 
    {
        String nomeElemento = elemento.Getnome();
        //Se a arvore estiver vazia
        if(raiz == null)
            raiz = new No(elemento, false);
        //Senao, se a arvore tiver um elemento 
        else if (raiz.esq == null && raiz.dir == null)
        {
            if (raiz.elemento.Getnome().compareTo(nomeElemento) > 0)
                raiz.esq = new No(elemento, true);
            else 
                raiz.dir = new No(elemento, true);
            Tp4ex4.ncomparacoes++;
        }
        //Senao, se a arvore tiver dois elementos (raiz e dir) 
        else if (raiz.esq == null)
        {
            if(raiz.elemento.Getnome().compareTo(nomeElemento) > 0)
            {
                Tp4ex4.ncomparacoes++;
                raiz.esq = new No(elemento);
            }
            else if (raiz.dir.elemento.Getnome().compareTo(nomeElemento) > 0)
            {
                Tp4ex4.ncomparacoes += 2;
                raiz.esq = new No(raiz.elemento);
                raiz.elemento = elemento;
            } 
            else 
            {
                Tp4ex4.ncomparacoes += 2;
                raiz.esq = new No(raiz.elemento);
                raiz.elemento = raiz.dir.elemento;
                raiz.dir.elemento = elemento;
            }
  
           raiz.esq.cor = raiz.dir.cor = false;
        }
        //Senao, se a arvore tiver dois elementos (raiz e esq) 
        else if (raiz.dir == null)
        {
           
            if(raiz.elemento.Getnome().compareTo(nomeElemento) < 0)
            {
                Tp4ex4.ncomparacoes++;
                raiz.dir = new No(elemento);
            }
            else if (raiz.esq.elemento.Getnome().compareTo(nomeElemento) < 0)
            {
                Tp4ex4.ncomparacoes += 2;
                raiz.dir = new No(raiz.elemento);
                raiz.elemento = elemento;
            } 
            else 
            {
                Tp4ex4.ncomparacoes += 2;
                raiz.dir = new No(raiz.elemento);
                raiz.elemento = raiz.esq.elemento;
                raiz.esq.elemento = elemento;
            }
    
            raiz.esq.cor = raiz.dir.cor = false;
  
        //Senao, a arvore tem tres ou mais elementos
        } 
        else 
            inserir(elemento, null, null, null, raiz);
  
        raiz.cor = false;
    }

    private void inserir(Jogador elemento, No bisavo, No avo, No pai, No i) throws Exception 
    {
        String nomeElemento = elemento.Getnome();
        if (i == null) 
        {
            if(nomeElemento.compareTo(pai.elemento.Getnome()) < 0)
            {
                Tp4ex4.ncomparacoes++;
                i = pai.esq = new No(elemento, true);
            }
            else 
                i = pai.dir = new No(elemento, true);

            if(pai.cor == true)
                balancear(bisavo, avo, pai, i);
        }
        else 
        {
            //Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
            if(i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true)
            {
                i.cor = true;
                i.esq.cor = i.dir.cor = false;
                if(i == raiz)
                    i.cor = false;
                else if(pai.cor == true)
                    balancear(bisavo, avo, pai, i);
            }
            if (nomeElemento.compareTo(i.elemento.Getnome()) < 0) 
            {
                Tp4ex4.ncomparacoes++;
                inserir(elemento, avo, pai, i, i.esq);
            }
            else if (nomeElemento.compareTo(i.elemento.Getnome()) > 0) 
            {
                Tp4ex4.ncomparacoes++;
                inserir(elemento, avo, pai, i, i.dir);
            }
            else 
                throw new Exception("Erro inserir (elemento repetido)!");
        }
    }
    
    private void balancear(No bisavo, No avo, No pai, No i){

        //Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
        if(pai.cor == true)
        {
            String nomePai = pai.elemento.Getnome();
            String nomeI = i.elemento.Getnome();
            String nomeAvo = avo.elemento.Getnome();
            //4 tipos de reequilibrios e acoplamento
            if(nomePai.compareTo(nomeAvo) > 0)
            { // rotacao a esquerda ou direita-esquerda
                Tp4ex4.ncomparacoes++;
                if(nomeI.compareTo(nomePai) > 0)
                    avo = rotacaoEsq(avo);
                else 
                    avo = rotacaoDirEsq(avo);
                Tp4ex4.ncomparacoes++;
            } 
            else
            {// rotacao a direita ou esquerda-direita
                if(nomeI.compareTo(nomePai) < 0)
                    avo = rotacaoDir(avo);
                else 
                    avo = rotacaoEsqDir(avo);
                Tp4ex4.ncomparacoes++;
            }
    
            if (bisavo == null)
            {
                raiz = avo;
                Tp4ex4.ncomparacoes++;
            }
            else 
            {
                Tp4ex4.ncomparacoes++;
                if(nomeAvo.compareTo(bisavo.elemento.Getnome()) < 0)
                    bisavo.esq = avo;
                else 
                    bisavo.dir = avo;
                Tp4ex4.ncomparacoes++;
            }
  
            //reestabelecer as cores apos a rotacao
            avo.cor = false;
            avo.esq.cor = avo.dir.cor = true;
        } //if(pai.cor == true)
        Tp4ex4.ncomparacoes++;
    }

    private No rotacaoDir(No no) 
    {
        No noEsq = no.esq;
        No noEsqDir = noEsq.dir;
  
        noEsq.dir = no;
        no.esq = noEsqDir;
  
        return noEsq;
    }
  
    private No rotacaoEsq(No no) 
    {
        No noDir = no.dir;
        No noDirEsq = noDir.esq;
  
        noDir.esq = no;
        no.dir = noDirEsq;
        return noDir;
    }
  
    private No rotacaoDirEsq(No no) 
    {
        no.dir = rotacaoDir(no.dir);
        return rotacaoEsq(no);
    }
  
    private No rotacaoEsqDir(No no) 
    {
        no.esq = rotacaoEsq(no.esq);
        return rotacaoDir(no);
    }
  
    public void pesquisa(String nome)
    {
        MyIO.print("raiz");
        pesquisa(nome,raiz);
    }

    public void pesquisa(String nome, No i)
    {
        if (i != null && nome.equals(i.elemento.Getnome()))
        {
            Tp4ex4.ncomparacoes++;
            MyIO.println(" SIM");
        }
        else if (i != null && nome.compareTo(i.elemento.Getnome()) < 0)
        {
            Tp4ex4.ncomparacoes += 2;
            MyIO.print(" esq");
            pesquisa(nome,i.esq);
        }
        else if (i != null && nome.compareTo(i.elemento.Getnome()) > 0)
        {
            Tp4ex4.ncomparacoes += 3;
            MyIO.print(" dir");
            pesquisa(nome,i.dir);
        }
        else
            MyIO.println(" NAO");
    }

    public int Getn()
    {
        return n;
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

public class Tp4ex4
{
    //numero de comparacoes
    public static int ncomparacoes;

    public static void Armazena(String valores, ArvoreBinaria Inicial) throws Exception
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

    public static void leitura(String link, ArvoreBinaria Inicial, String[] entrada, int nentrada) throws Exception
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
            }while (Inicial.Getn() != nentrada && n != nentrada);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public static boolean isFim(String entrada)
    {
        boolean resp = false;
        if (entrada.equals("FIM"))
            resp = true;
        return resp;
    } 

    public static void CriacaoLog(int matricula, long tempexecuao) throws IOException
    {
        File log = new File("matricula_avinegra.txt");
        log.createNewFile();
        FileWriter arqlog = new FileWriter(log);
        BufferedWriter warqlog = new BufferedWriter(arqlog);
        warqlog.write(Integer.toString(matricula)+"\t"+Integer.toString(ncomparacoes)+"\t"+Long.toString(tempexecuao)+"s");
        warqlog.close();
        arqlog.close();
    }

    public static void main (String [] args) throws Exception
    {
        //tempo inicial
        long TempoInicial = System.currentTimeMillis();
        ncomparacoes = 0;
        String[] entrada = new String[4000];
        int Nentrada = 0;
        do
        {
            entrada[Nentrada] = MyIO.readLine();
        }while(!isFim(entrada[Nentrada++]));
        Nentrada--;
        ArvoreBinaria dados = new ArvoreBinaria();
        leitura("/tmp/players.csv", dados, entrada, Nentrada);
        String[] entrada2 = new String[4000];
        int Nentrada2 = 0;
        do
        {
            entrada2[Nentrada2] = MyIO.readLine();
        }while(!isFim(entrada2[Nentrada2++]));
        Nentrada2--;
        for(int i = 0;i < Nentrada2;i++)
        {
            MyIO.print(entrada2[i]+" ");
            dados.pesquisa(entrada2[i]);
        }
        try
        {
            CriacaoLog(684903, System.currentTimeMillis() - TempoInicial);
        }
        catch (IOException erro)
        {
            System.err.println("Erro nao foi possivel criar o log do arquivo");
        }
    }
}