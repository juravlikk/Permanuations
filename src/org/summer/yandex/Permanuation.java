package org.summer.yandex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Permanuation {
	
	private static long count = 0;
	private int N;
	private long K;
	private String[] a;
	private FileWriter fw;
	
	public static void main( String[] args ) throws IOException {
		new Permanuation().run();
	}
	
	private void run() throws IOException {
   		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
   		String n = br.readLine();
   		String k = br.readLine();
   		N = Integer.parseInt(n);
   		K = Long.parseLong(k);
   		br.close();
   		
   		fw = new FileWriter("output.txt");
   		
   		a = new String[N];
   		for (int i = 0; i < N; i++) {
   			a[i] = Integer.toString(N - i);
   			fw.write(Integer.toString(i + 1));
   			if (i < N - 1) {
   				fw.write(" ");
   			}
   		}
		fw.write("\n");
		count++;

		getPermanuations(N, N - 1, N, "");
		
   		fw.flush();
		fw.close();
    }
	
	private void getPermanuations(int n, int start, int repeat, String prefix) throws IOException {
		if (n == 1) {
			fw.write(prefix + a[0] + " " + a[1] + "\n");
			count++;
			return;
		}
		String temp;
		int index = 0;
		int i = 0;
		while(count < K && index < repeat) {

			temp = a[i];
			a[i] = a[i + 1];
			a[i + 1] = temp;
			
			fw.write(prefix);
			for (int j = start; j > 0; j--) {
				fw.write(a[j] + " ");
			}
			fw.write(a[0] + "\n");
						
			count++;
			i++;
			
			if (i > 1 && i < start) {
				String temp_p = prefix;
				for (int j = start; j > i; j--) {
					temp_p = temp_p + a[j] + " ";
				}
				String array[] = new String[i + 1];
				System.arraycopy(a, 0, array, 0, i + 1);
				getPermanuations(i, i, i - 1, temp_p);
				System.arraycopy(array, 0, a, 0, i + 1);
			}
			
			if (i == start) {
				i = 0;
				index++;
			}
		}
		if (count >= K) {
			return;
		}
		if (index == repeat && index < N) {
			prefix = prefix + a[n] + " ";
			getPermanuations(n - 1, n - 1, n - 1, prefix);
		}
	}
}
