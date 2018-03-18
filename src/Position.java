public class Position {
	public static final int MAX_X = 3;
	public static final int MAX_Y = 3;
	private int x;
	private int y;
	public static void main(String[] args) {
		Position p = new Position (1, 3);

		System.out.println(p);
		p.moveUpOrDown(3);
		System.out.println(p);
		p.moveLeftOrRight(1);
		System.out.println(p);
		p.moveUpOrDown(-1);
		System.out.println(p);
		p.moveLeftOrRight(-11);
		System.out.println(p);
		p.moveUpOrDown(-10);
		System.out.println(p);
		p.moveLeftOrRight(8);
		System.out.println(p);
		p.moveUpOrDown(22);
		System.out.println(p);

		System.out.println(p.equals(new Position(2,2))); 
		System.out.println(p.equals(null)); 
	}

	public Position(int x, int y){	
		if (x <= 0) {
			this.x = 1;
		}
		else if(x > MAX_X){
			this.x = MAX_X;
		}
		else{
			this.x = x;
		}
		if (y <= 0) {
			this.y = 1;
		}
		else if(y > MAX_Y){
			this.y = MAX_Y;
		}
		else{
			this.y = y;
		}
	}

	public boolean equals (Position p){
		if (p == null){
			return false;
		}
		else if (p.x == x && p.y == y) {
			return true;
		}
		else{
			return false;
		}
	}

	public String toString(){
		return "("+ x + ", " + y + ")";
	}

	public void moveLeftOrRight(int byNum){
		x += byNum;

		if (x > MAX_X ) {
			x %= MAX_X;

		}
		while(x <= 0 ) {
			x += MAX_X;
		}


	}

	public void moveUpOrDown(int byNum)
	{
		y += byNum;

		if (y > MAX_Y ) {
			y %= MAX_Y;

		}
		while(y <= 0 ) {
			y += MAX_Y;
		}
	}



}

