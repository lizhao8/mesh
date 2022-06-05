package com.mesh.object.base;

import java.util.Objects;

public class Point2D {
	protected float x;
	protected float y;

	public Point2D(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}

	public float x() {
		return x;
	}

	public void x(float x) {
		this.x = x;
	}

	public float y() {
		return y;
	}

	public void y(float y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2D other = (Point2D) obj;
		return Float.floatToIntBits(x) == Float.floatToIntBits(other.x)
				&& Float.floatToIntBits(y) == Float.floatToIntBits(other.y);
	}

	@Override
	public String toString() {
		return "Point2D [x=" + x + ", y=" + y + "]";
	}

}
