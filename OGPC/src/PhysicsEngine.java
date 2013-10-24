public class PhysicsEngine 
{
	double v;
	double vf;
	double dx;
	double dy;
	static double a;
	
	PhysicsEngine()
	{
		v = 0;
		vf = 0;
		dx = 0;
		dy = 0;
		a = -9.8;
	}
	
	//dx = .5(vi + vf)dt
	public double changeInX(double vi, double vf, double dt)
	{
		dx = .5 * (vi + vf) * dt;
		
		return dx;
	}
	
	//vf = vi + a(dt)
	public double velocityFinal(double vi, double dt)
	{
		vf = vi + (a * dt);
		
		return vf;
	}
	
	//h = (.5a)(dt)^2 + vi(dt)
	public double changeInY(double vi, double t)
	{
		dy = (.5 * a) * (Math.pow(t, 2)) + (vi * t);
		
		return dy;
	}
}
