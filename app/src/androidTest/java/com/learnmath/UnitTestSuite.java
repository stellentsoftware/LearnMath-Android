package com.learnmath;



import com.learnmath.TestCases.ApplyMathAddition;
import com.learnmath.TestCases.ApplyMathDivision;
import com.learnmath.TestCases.ApplyMathMultipplication;
import com.learnmath.TestCases.ApplyMathSubtraction;
import com.learnmath.TestCases.DrillMathAddition;
import com.learnmath.TestCases.DrillMathDivision;
import com.learnmath.TestCases.DrillMathMultiplication;
import com.learnmath.TestCases.DrillMathSubtraction;
import com.learnmath.TestCases.LearnMathAddition;
import com.learnmath.TestCases.LearnMathDivision;
import com.learnmath.TestCases.LearnMathMultiplication;
import com.learnmath.TestCases.LearnMathSubtraction;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Runs all unit tests.
@RunWith(Suite.class)
@Suite.SuiteClasses({
        LearnMathAddition.class,LearnMathSubtraction.class, LearnMathMultiplication.class,LearnMathDivision.class,
        ApplyMathAddition.class,ApplyMathSubtraction.class, ApplyMathMultipplication.class, ApplyMathDivision.class,
        DrillMathAddition.class, DrillMathSubtraction.class, DrillMathMultiplication.class, DrillMathDivision.class})
public class UnitTestSuite {
}