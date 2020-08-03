package com.hedron.meditate.util

import org.junit.Assert
import org.junit.Test

class ConstantTest {

    @Test
    fun test_Constants() {
        val c = Constant
        Assert.assertTrue(c.Angry!=null)
        Assert.assertTrue(c.Fear!=null)
        Assert.assertTrue(c.Sad!=null)
        Assert.assertTrue(c.Sick!=null)
        Assert.assertTrue(c.Suprise!=null)
        Assert.assertTrue(c.Happy!=null)
   }

}