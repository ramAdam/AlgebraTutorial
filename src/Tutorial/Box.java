package Tutorial;

import Graphics.Shader;
import Graphics.Texture;
import Input.Input;
import Math.Matrix4f;
import Math.Vector3f;
import static org.lwjgl.glfw.GLFW.*;

public class Box extends GameObject{

	public static float width = 3.5f;
	public static float height = 3.5f;
	public Vector3f delta = new Vector3f();
	
	public boolean running = false;
	public boolean jumping = false;
	public boolean idle = true;
	public boolean walking = false;
	
	
	public int spritePos = 0;
	public int counter = 0;
	public int animState = 0;
	
	public float rot = 0.0f;
	
	private static float[] vertices = new float[]{
			-width, -height, 0.2f,
			-width,  height, 0.2f,
			  width,  height, 0.2f,
			  width, -height, 0.2f
	};
	
	private static float[] texCoords = new float[]{
			0, 1,
			0, 0,
			1, 0,
			1, 1
	};
	
	private static byte[] indices = new byte[]{
			0,1,2,
			2,3,0
	};
	
	private static String texPath = "assets/crate.jpg";
	
	public Box(){
		super(vertices, indices, texCoords, texPath);
	}
	

	
	@Override
	public void render(){
		
		tex.bind();
		Shader.shader1.enable();
		// Uncomment different lines to see different rotation effects
//		Shader.shader1.setUniformMat4f("ml_matrix", Matrix4f.translate(position).multiply(Matrix4f.rotateX(rot)));
//		Shader.shader1.setUniformMat4f("ml_matrix", Matrix4f.translate(position).multiply(Matrix4f.rotateY(rot)));
		Shader.shader1.setUniformMat4f("ml_matrix", Matrix4f.translate(position).multiply(Matrix4f.rotateZ(rot)));
		VAO.render();
		Shader.shader1.disable();
		tex.unbind();
		
	}
	
	@Override
	public void update(){
		rot += 0.1f;
		// Uncomment different lines to see different translation effects
//		position.x += 0.01f;
//		position.y += 0.01f;
//		position.z += 0.01f;
	}

	
}
