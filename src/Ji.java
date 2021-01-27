import java.util.Scanner;

public class Ji {
public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	int n=input.nextInt();//tedade kar
	String array[]=new String[n];//arraye az baze ha
	ArrayList<Tree> list=new ArrayList();//masale ha
	ArrayList<String> numbers=new ArrayList();//adad haye kar ha
	input.nextLine();
	for(int i=0;i<n;i++)
		array[i]=input.nextLine();//gereftane baze ha
	for(int i=0;i<n;i++) {
		String tmp[]=array[i].split(" ");
		Tree tree=new Tree(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]),i+1);//derekhat
		boolean flag=false;//flage makhsoose hampooshani ya na
		for(int t=0;t<list.getSize();t++) {
			if(list.get(t).data.insert(tree)==true) {//hampooshani nashode
				flag=true;
				numbers.get(t).data+=String.valueOf(tree.work+" ");
				
				break;
				
			}
		}
		if(flag==false) {//hampooshani shode
			numbers.addLast(new String(String.valueOf(tree.work+" ")));

			list.addLast(tree);}
			
	}
	for(int i=0;i<numbers.getSize();i++)//print javab 
		System.out.println(numbers.get(i).data);
		
	
}
}
/**
 * class Tree
 * leftD:adade chap
 * leftR:adade rast
 * left:derakhti ba bazev zamani aghabtar
 * eft:derakhti ba baze zamani jelotar
 * @author Asus
 *
 */
class Tree{
	int leftD;
	int rightD;
	int work;
	Tree left;
	Tree right;
	public Tree(int leftD, int rightD,int work) {
	
		this.work=work;
		this.leftD = leftD;
		this.rightD = rightD;
	}
	/**
	 * insert()
	 * bazgashte kar mikonad
	 * return true:hampooshani nashode va jaygozari shode
	 * return false:hampooshani shode va jaygozari nashode
	 * agar if aval ejra shavad yani ham pooshani nadarim va check mikonad baze jelotar ast ya aqab tar.sepas agar aqab tar bood check mikonad aqab tar null ast ya na.agar bood 
	 * left=tr vagarna an ra be samte lst miferestad ta left ham check konad va...
	 * va baraye rasr ham hamintor ast
	 * @param tr
	 * @return
	 */
	public boolean insert(Tree tr) {
	
		if(leftD>=tr.rightD || rightD<=tr.leftD)
		{
			if(leftD>=tr.rightD)//baze jelotar
			{
				if(left==null) {
					left=tr;
					return true;
				}else 
					return left.insert(tr);
					
			}
			else if(rightD<=tr.rightD)//baze aqabtar
			{
				if(right==null) {
					right=tr;
					return true;}
				else 
					return right.insert(tr);
					
			}
		}
			return false;//hampoohani shode
	}
	
}
/**
 * array list
 * @author Asus
 *
 * @param <E>
 */
class ArrayList<E> extends LinkedList<E>{
	public Node get(int i) {
		Node node=super.start;
		int n=0;
		while(n!=i && node.next!=null) {
			node=node.next;
			n++;
		}
		return node;
		
	}
	public int indexOf(E ob) {
		Node tmp=super.start;
		int n=0;
		while(tmp!=null) {
			
			
		
			if(tmp.data.equals(ob))
				return n;
			else
				tmp=tmp.next;
			n++;
		}
		return -1;
	}
	public String toString() {
		return super.toString();
	}
}