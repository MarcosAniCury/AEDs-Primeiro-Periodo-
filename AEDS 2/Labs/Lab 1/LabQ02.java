class LabQ02
{
	public static int Maiuscula (String entrada, int i, int j)
	{
		j = 0;
		if(j < entrada.length())
		{
			if(isMaiuscula(entrada.charAt(j) == true)
				i++;
			Maiuscula(entrada, i, j++);
		}
		return i;
	}
	public static boolean isMaiuscula (char l)
	{
		return (l >= 'A' && l <= 'Z');
	}
	public static int Maiuscula(String entrada)
	{
		return Maiuscula(entrada, 0, 0);
	}
	public static boolean isFim(String s)
	{
		return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
	}
	public static void main(String [] args)
	{
		String[] entrada = new String[1000];
		int numEntrada = 0;
		//leitura padrao da entrada 
		do
		{
			entrada[numEntrada] = MyIO.readLine();
		} while (isFim(entrada[numEntrada++]) == false);
		numEntrada--;
		// Desconsiderar ultima linha contendo a palavra FIM
		//Para cada linha de entrada, gerando uma de saida contendo o numero de letras maiusculas da entrada
		for(int i = 0; i < numEntrada; i++)
		{
			MyIO.println(Maiusculas(entrada[i]));
		}
	}
}
