/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Theresa
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
   AccountChargeTestCase.class,
    BvnValidationTestCase.class,
    CardChargeTestCase.class,
    QRChargeTestCase.class,
    RecurringPaymentTestCase.class,
    SubAccountTestCase.class,
    TransferTestCase.class

})
public class JUnitTestSuite {

}
