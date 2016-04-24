package com.arindam.util;

/**
 * Created by ARINDAM on 24-04-2016.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenGenerator {




    public static List<String> convert_type (String[] array){

        List<String> return_it = new LinkedList<String>() ;

        for(int j=0;j<array.length;j++){
            return_it.add(array[j]);
        }

        return return_it;

    }


    public static String[] space_optimizer(String[] array){

        List<String> string_temp = new LinkedList<String>();
        for(int i=0; i<array.length;i++){

            Pattern pattern = Pattern.compile("\\s");
            Matcher matcher = pattern.matcher(array[i]);
            boolean found = array[i].matches("^\\s*$");
            if(found){
                System.out.println("Not to add");
            }
            else{
                string_temp.add(array[i]);
            }

        }

        String[] trimmed_array = new String[string_temp.size()] ;

        for(int j=0; j<string_temp.size();j++){

            trimmed_array[j]=string_temp.get(j);

        }


        return trimmed_array;
    }


    public static String conversion_helper(String[] args){

        String send = "" ;

        for(int i=0;i<args.length;i++){
            send= send+args[i];
        }


        return send;

    }



}

