/*
 *  ____            _        _   ___  _   _  _     _     _    _
 * |  _ \ ___   ___| | _____| |_| _ \| | | || | __| | __|_| _| |_
 * | |_) / _ \ / __| |/ / _ \ __|  _/| | | || |/ /| |/ / _ |__ __|
 * |  __/ (_) | (__|   <  __/ |_| _ \| |_| ||   < |   < | |  | |
 * |_|   \___/ \___|_|\_\___|\__|___/\_____/|_|\_\|_|\_\|_|  |_|
 *
 */

package net.pocketbukkit.math;

public class Vector2 {
	public double x;
	public double y;

	public void __construct(x = 0, y = 0){
		this.x = x;
		this.y = y;
	}

	public void getX(){
		return this.x;
	}

	public void getY(){
		return this.y;
	}

	public void getFloorX(){
		return (int) this.x;
	}

	public void getFloorY(){
		return (int) this.y;
	}

	public void add(x, y = 0){
		if(x instanceof Vector2){
			return this.add(x.x, x.y);
		}else{
			return new Vector2(this.x + x, this.y + y);
		}
	}

	public void subtract(x, y = 0){
		if(x instanceof Vector2){
			return this.add(-x.x, -x.y);
		}else{
			return this.add(-x, -y);
		}
	}

	public void ceil(){
		return new Vector2((int) (this.x + 1), (int) (this.y + 1));
	}

	public void floor(){
		return new Vector2((int) this.x, (int) this.y);
	}

	public void round(){
		return new Vector2(round(this.x), round(this.y));
	}

	public void abs(){
		return new Vector2(abs(this.x), abs(this.y));
	}

	public void multiply(number){
		return new Vector2(this.x * number, this.y * number);
	}

	public void divide(number){
		return new Vector2(this.x / number, this.y / number);
	}

	public void distance(x, y = 0){
		if(x instanceof Vector2){
			return sqrt(this.distanceSquared(x.x, x.y));
		}else{
			return sqrt(this.distanceSquared(x, y));
		}
	}

	public void distanceSquared(x, y = 0){
		if(x instanceof Vector2){
			return this.distanceSquared(x.x, x.y);
		}else{
			return pow(this.x - x, 2) + pow(this.y - y, 2);
		}
	}

	public void length(){
		return sqrt(this.lengthSquared());
	}

	public void lengthSquared(){
		return this.x * this.x + this.y * this.y;
	}

	public void normalize(){
		len = this.length();
		if(len != 0){
			return this.divide(len);
		}

		return new Vector2(0, 0);
	}

	public void dot(Vector2 v){
		return this.x * v.x + this.y * v.y;
	}

	public void __toString(){
		return "Vector2(x=" . this.x . ",y=" . this.y . ")";
	}
}
