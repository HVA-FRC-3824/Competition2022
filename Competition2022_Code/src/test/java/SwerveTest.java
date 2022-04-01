// import static org.junit.Assert.*;
// import org.junit.*;

// import frc.robot.subsystems.Chassis;

// public class SwerveTest {
//     private Chassis m_chassis;

//     @Before
//     public void setup()
//     {
//         m_chassis = new Chassis();
//     }

//     @After
//     public void shutdown() throws Exception
//     {
//     }

//     @Test
//     public void SwerveTest()
//     {
//         // double [] frontRight = {0, 0, 0, 0, 0, 0};
//         // double [] frontLeft = {0, 0, 0, 0, 0, 0};
//         // double [] backLeft = {0, 0, 0, 0, 0, 0};
//         // double [] backRight = {0, 0, 0, 0, 0, 0};
        
//         // Set up input
//         double fakeX1Input = 0;
//         double fakeY1Input = 0.5;
//         double fakeX2Input = 0.0;
        
//         // Feed input into test function
//         m_chassis.convertSwerveValues(fakeX1Input, fakeY1Input, fakeX2Input);

//         // Gather output
//         double frontRightAngle = m_chassis.getMotorFR().get();
//         double frontLeftAngle = m_chassis.getMotorFL().get();
//         double backRightAngle = m_chassis.getMotorBR().get();
//         double backLeftAngle = m_chassis.getMotorBL().get();

//         // Test output is correct
//         assertEquals(0, frontRightAngle, 0.0001);
//         assertEquals(0, frontLeftAngle, 0.0001);
//         assertEquals(0, backRightAngle, 0.0001);
//         assertEquals(0, backLeftAngle, 0.0001);

//         fakeX1Input = 0.5;
//         fakeY1Input = 0.0;
//         fakeX2Input = 0.0;

//         m_chassis.convertSwerveValues(fakeX1Input, fakeY1Input, fakeX2Input);
        
//         frontRightAngle = m_chassis.getMotorFR().get();
//         frontLeftAngle = m_chassis.getMotorFL().get();
//         backRightAngle = m_chassis.getMotorBR().get();
//         backLeftAngle = m_chassis.getMotorBL().get();

//         System.out.println("Expected: 6144");
//         System.out.println("Actual1: " + frontRightAngle);
//         System.out.println("Actual2: " + frontLeftAngle);
//         System.out.println("Actual3: " + backRightAngle);
//         System.out.println("Actual4: " + backLeftAngle);

//         assertEquals(6144, frontRightAngle, 10.0);
//         assertEquals(6144, frontLeftAngle, 10.0);
//         assertEquals(6144, backRightAngle, 10.0);
//         assertEquals(6144, backLeftAngle, 10.0);
//     }
// }