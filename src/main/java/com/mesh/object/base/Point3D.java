package com.mesh.object.base;

import java.util.Objects;

public class Point3D extends Point2D {
	private float z;

	public Point3D(float x, float y, float z) {
		super(x, y);
		this.z = z;
	}

	public float z() {
		return z;
	}

	public void z(float z) {
		this.z = z;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y, z);

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3D other = (Point3D) obj;
		return Float.floatToIntBits(x) == Float.floatToIntBits(other.x)
				&& Float.floatToIntBits(y) == Float.floatToIntBits(other.y)
				&& Float.floatToIntBits(z) == Float.floatToIntBits(other.z);
	}

}
