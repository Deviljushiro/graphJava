package maze;

import graph.*;
import java.lang.*;

public class Maze extends MatAdj{

	public Cell[][] matrice;
	public Cell depart;
	public Cell arrival;
	public int taille;
	
	public Maze(int taille, int xD, int yD, int xA, int yA) {
		
		this.taille=taille;
		matrice = new Cell[taille][taille];
		depart = new Cell("DBox",xD,yD);
		arrival = new Cell("ABox",xA,yA);
		
		matrice[xD][yD]=depart;
		matrice[xA][yA]=arrival;
		
		for (int i=0;i<taille;i++)
		{
			for (int j=0;j<taille;j++)
			{
				
				super.adj[i][j]=false;
			}
		}
		
	}
	
	/**Ajoute un chemin traversable de c1 vers c2 en supposant que c1 est deja un endroit traversable*/
	public void addWay(Cell c1, Cell c2)
	{
		if (c1.type!="Ebox"||c1.type!="DBox")
		{
			if (((Math.abs(c1.x-c2.x)==0)&&(Math.abs(c1.y-c2.y)==1)||((Math.abs(c1.x-c2.x)==1)&&(Math.abs(c1.y-c2.y)==0))))
			{
				Edge e = new UndirectedEdge(c1,c2);
				super.addEdge(e);
				matrice[c2.x][c2.y].type="Ebox";
			}
		}
		else if (c2.type=="ABox")
		{
			if (((Math.abs(c1.x-c2.x)==0)&&(Math.abs(c1.y-c2.y)==1)||((Math.abs(c1.x-c2.x)==1)&&(Math.abs(c1.y-c2.y)==0))))
			{
				Edge e = new UndirectedEdge(c1,c2);
				super.addEdge(e);
			}
		}
	}
	
	/**Cree automatiquement des murs sur tous les emplacements restant du depart, de m'arrivee et des chemins*/
	public void addWall()
	{
		for (int i=0;i<taille;i++)
		{
			for (int j=0;j<taille;j++)
			{
				if (matrice[i][j].type!="DBox"||matrice[i][j].type!="ABox"||matrice[i][j].type!="EBox")
				{
					matrice[i][j].type="WBox";
				}
			}
		}
	}
	
	public void printMaze()
	{
		for (int i=0;i<taille;i++)
		{
			for (int j=0;j<taille;j++)
			{
				if (matrice[i][j].type=="WBox") {System.out.print("O");}
				else if (matrice[i][j].type=="EBox") {System.out.print(".");}
				else if (matrice[i][j].type=="DBox") {System.out.print("D");}
				else if (matrice[i][j].type=="ABox") {System.out.print("A");}
			}
		}
		System.out.print("\n");
	}
}
