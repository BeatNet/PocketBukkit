package net.pocketbukkit.api.math;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

import org.blockserver.math.Vector3d;

public class Matrix4d {
	public double[] matrix = new double[4 * 4];
	
	public static Matrix4d identity() {
		Matrix4d result = new Matrix4d();
		for(int i = 0; i < 4 * 4; i++) {
			result.matrix[i] = 0.0f;
		}
		result.matrix[0 + 0 * 4] = 1.0f;
		result.matrix[1 + 1 * 4] = 1.0f;
		result.matrix[2 + 2 * 4] = 1.0f;
		result.matrix[3 + 3 * 4] = 1.0f;
		
		return result;
	}
	
	public Matrix4d multiply(Matrix4d matrix) {
		Matrix4d result = new Matrix4d();
		for(int y = 0; y < 4; y++) {
			for(int x = 0; x < 4; x++) {
				double sum = 0.0f;
				for(int e = 0; e < 4; e++) {
					sum += this.matrix[e + y * 4] * matrix.matrix[x + e * 4];
				}
				result.matrix[x + y * 4] = sum;
			}
		}
		return result;
	}

	public static Matrix4d translate(Vector3d vector) {
		Matrix4d result = identity();
		result.matrix[0 + 3 * 4] = vector.getX();
		result.matrix[1 + 3 * 4] = vector.getY();
		result.matrix[2 + 3 * 4] = vector.getZ();
		return result;
	}
	
	public static Matrix4d rotate(double angle) {
		Matrix4d result = identity();
		double r = (double) (toRadians(angle));
		double cos = (double) (cos(r));
		double sin = (double) (sin(r));
		
		result.matrix[0 + 0 * 4] = cos;
		result.matrix[1 + 0 * 4] = sin;
		
		result.matrix[0 + 1 * 4] = -sin;
		result.matrix[1 + 1 * 4] = cos;
		
		return result;
	}
	
	public static Matrix4d orthographic(double left, double right, double bottom, double top, double near, double far) {
		Matrix4d result = identity();
		
		result.matrix[0 + 0 * 4] = 2.0f / (right - left);
		
		result.matrix[1 + 1 * 4] = 2.0f / (top - bottom);
		
		result.matrix[2 + 2 * 4] = 2.0f / (near - far);
		
		result.matrix[0 + 3 * 4] = (left + right) / (left - right);
		result.matrix[1 + 3 * 4] = (bottom + top) / (bottom - top);
		result.matrix[2 + 3 * 4] = (near + far) / (far - near);
		
		return result;
	}
}
