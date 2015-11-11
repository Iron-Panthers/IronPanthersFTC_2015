class GamePiece 
{
	public DcMotor gamePieceMotor;
	public Servo gamePieceDump;

	gamePieceMotor = hardwareMap.DcMotor.get("gamePieceMotor");
	gamePieceDump = hardwareMap.Servo.get("gamePieceDump");

	public static final double SERVO_DOWN = 0; //needs value
	public static final double SERVO_UP = 0; //needs value

	public static final double MOTOR_SPEED = 1;
	public static final double MOTOR_OFF = 0;

	public GamePiece()
	{
		public boolean servoUp = true;
		public boolean motorOn = true;
		gamePieceDump.setServoPosition(SERVO_UP);
	}

	public void toggleGamePieceDump() 
	{
		if(servoUp == false)
		{
	 		gamePieceDump.setServoPosition(SERVO_UP);
		}
		else if(servoUp == true)
		{
			gamePieceDump.setServoPosition(SERVO_DOWN);
		}
	}
	public void toggleGamePieceMotor()
	{	
		if(motorOn == false)
	}

		{
		 	gamePieceMotor.setMotorPower(MOTOR_SPEED);
		}
		else if(motorOn == true)
		{
		 	gamePieceMotor.setMotorPower(MOTOR_OFF);
		}