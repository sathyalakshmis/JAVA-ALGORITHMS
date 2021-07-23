import java.util.Scanner;
class Kruskals {
	public static void main(String [] args) {
	Compute c = new Compute();
	c.ReadFromConsole();
	c.Kruskal();
	}
}
class Compute {
private static int n;
	int[][]cost;
	int[]parent;
	public void ReadFromConsole() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of nodes");
		n= sc.nextInt();
		cost = new int[n+2][n+2];
		parent = new int[n+2];
		System.out.println("Enter cost matrix");
		for(int i=1;i<=n;i++) {
			parent[i]=0;
			for(int j=1;j<=n;j++) {
				  cost[i][j] = sc.nextInt();
					if (cost[i][j]==0) cost[i][j] = 999;
				}
			}
	sc.close();
}
public void Kruskal() {
		int i,j,a=0,b=0,u=0,v=0,min,mincost=0,ne=1;
		System.out.println("The edges of Minimum Cost Spanning Treeare");
		while(ne<n) {
			for(i=1,min=999;i<=n;i++)
				for(j=1;j<= n;j++)
					if(cost[i][j] < min) {
						min=cost[i][j];
						a=u=i;
						b=v=j;
					}
		u=find(u);
		v=find(v);
		if(uni(u,v)==1) {
			System.out.println(ne++ + " edge(" + a + "," + b + ")= " +min);
			mincost +=min;
		}
		cost[a][b]= cost[b][a] = 999;
	}
	System.out.println("Minimum cost = " + mincost);
}
public int find(int i) {
	while(parent[i]!=0) i=parent[i];
	return i;
}
public int uni(int i,int j) {
	if (i != j) {
	parent[j] = i; return 1;
	}
	return 0;
}
}
