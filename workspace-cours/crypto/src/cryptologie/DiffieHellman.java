package cryptologie;

public class DiffieHellman {

	public static void main(String[] args) {

		int p = 23;

		int g = 3;

		int a = 6;
		int b = 15;

		int A = (int) Math.pow(g, a) % p;
		int B = (int) Math.pow(g, b) % p;

		int S_A = (int) Math.pow(B, a) % p;
		int S_B = (int) Math.pow(A, b) % p;

		if (S_A == S_B) {
			System.out.println("Fonctionne");
			System.out.println("Secret : " + S_A);
		}

		else {
			System.out.println("Erreur");
		}
	}

}
