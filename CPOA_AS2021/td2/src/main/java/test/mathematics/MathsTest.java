package test.mathematics;

import exceptions.MathsExceptions;
import interfaces.IMaths;
import mathematics.Maths;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MathsTest {

    private IMaths maths;

    @Before
    public void setUp(){
        this.maths = new Maths();
    }


    @Test
    public void testAdditionCasGeneralNombrePositif(){
        Assert.assertEquals(maths.addition(2,3), 5);
    }

    @Test
    public void testAdditionCasGeneralNombreNegatif(){
        Assert.assertEquals(maths.addition(2,-3), -1);
    }



    @Test
    public void testMultiplicationCasGeneral() throws MathsExceptions {Assert.assertEquals(maths.multiplication(2,5),10);}

    @Test
    public void testMultiplicationParZero() throws MathsExceptions {Assert.assertEquals(maths.multiplication(2,0),0);}

    @Test
    public void testMultiplicationNombreNegatif() throws MathsExceptions {Assert.assertEquals(maths.multiplication(-2,10),-20);}

    @Test
    public void testMultiplicationParNull() throws MathsExceptions {Assert.assertEquals(maths.multiplication(2,null),null);}




    @Test(expected = MathsExceptions.class)
    public void testDivisionParZero() throws MathsExceptions {
        try{
            maths.division(4,0);
        }catch (MathsExceptions e){
            Assert.assertEquals(e.getMessage(), "Division par zero impossible");
            throw e;
        }
    }
}