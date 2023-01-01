import java.awt.Graphics;

public class BoundingBox {
		private int[] pos = new int[2];
		private int width, height, top, bottom, left, right;
		
		public BoundingBox () {
			this(0, 0, 20, 20);
		}
		public BoundingBox (int inputX, int inputY, int inputWidth, int inputHeight) {
			pos[0] = inputX - (inputWidth / 2); pos[1] = inputY - (inputHeight / 2);
			width = inputWidth; height = inputHeight;
			
			top = pos[1];
			bottom = pos[1] + height;
			left = pos[0];
			right = pos[0] + width;
		}
		public BoundingBox (int inputX, int inputY, int inputWidth, int inputHeight, boolean hardPos) {
			pos[0] = inputX; pos[1] = inputY;
			width = inputWidth; height = inputHeight;
			
			top = pos[1];
			bottom = pos[1] + height;
			left = pos[0];
			right = pos[0] + width;
		}
		
		public void update (int inputX, int inputY, int inputWidth, int inputHeight) {
			pos[0] = inputX - (inputWidth / 2); pos[1] = inputY - (inputHeight / 2);
			width = inputWidth; height = inputHeight;
			
			top = pos[1];
			bottom = pos[1] + height;
			left = pos[0];
			right = pos[0] + width;
		}
		public void update (int inputX, int inputY, int inputWidth, int inputHeight, boolean hardPos) {
			pos[0] = inputX; pos[1] = inputY;
			width = inputWidth; height = inputHeight;
			
			top = pos[1];
			bottom = pos[1] + height;
			left = pos[0];
			right = pos[0] + width;
		}
		
		public void render(Graphics g, Camera camera) {
			g.drawRect(pos[0] + camera.getPos()[0], pos[1] + camera.getPos()[1], width, height);
		}
		
		
		public boolean boxCollision (BoundingBox a, BoundingBox b) {
			if (a.left < b.right && a.right > b.left && a.top < b.bottom && a.bottom > b.top) return true;
			else return false;
			
		}
		
		
		public int getLeft() {return left;}
		public int getRight() {return right;}
		public int getTop() {return top;}
		public int getBottom() {return bottom;}
		public int[] getPos() {return pos;}
		public int getWidth() {return width;}
		public int getHeight() {return height;}
	}