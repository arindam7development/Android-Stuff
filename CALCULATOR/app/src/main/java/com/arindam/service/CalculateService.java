package com.arindam.service;

/**
 * Created by ARINDAM on 24-04-2016.
 */

import com.arindam.evaluate.PostfixEvaluator;
import com.arindam.parser.ShuntingYardParser;
import com.arindam.util.TokenGenerator;

import java.math.BigDecimal;
import java.util.List;

import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class CalculateService {

    public BigDecimal execute(String android_input) throws ScriptException{


        String[] input = android_input.split(" ");

        String[] trimmed = TokenGenerator.space_optimizer(input);

        String[] postfix = ShuntingYardParser.infixToRPN(trimmed);

        List<String> to_be_cal = TokenGenerator.convert_type(postfix);

        PostfixEvaluator pst = new PostfixEvaluator(to_be_cal);

        try{

            return pst.result();

        } catch(Exception e){

            double d =  (double) new ScriptEngineManager().getEngineByName("JavaScript").eval(android_input);

            BigDecimal returnable = new BigDecimal(d);

            return returnable ;
        }


    }


}
