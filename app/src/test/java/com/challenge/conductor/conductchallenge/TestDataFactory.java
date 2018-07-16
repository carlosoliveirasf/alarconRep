package com.challenge.conductor.conductchallenge;

import com.challenge.conductor.conductchallenge.vo.ExtratoVO;
import com.google.gson.Gson;


public class TestDataFactory{

    public ExtratoVO getExtratoVoData(){
        Gson gson = new Gson();
       ExtratoVO extratoVO = gson.fromJson("{\n" +
               "    \"purchases\": [\n" +
               "        {\n" +
               "            \"date\": \"2018-10-01T00:00:00.000Z\",\n" +
               "            \"store\": \"Ricardo Eletro - OUT\",\n" +
               "            \"description\": \"Parcela 10\",\n" +
               "            \"value\": 19.9\n" +
               "        },\n" +
               "        {\n" +
               "            \"date\": \"2018-10-01T00:00:00.000Z\",\n" +
               "            \"store\": \"Ricardo Eletro - OUT\",\n" +
               "            \"description\": \"Parcela 10\",\n" +
               "            \"value\": 19.9\n" +
               "        },\n" +
               "        {\n" +
               "            \"date\": \"2018-10-01T00:00:00.000Z\",\n" +
               "            \"store\": \"Ricardo Eletro - OUT\",\n" +
               "            \"description\": \"Parcela 10\",\n" +
               "            \"value\": 19.9\n" +
               "        },\n" +
               "        {\n" +
               "            \"date\": \"2018-10-01T00:00:00.000Z\",\n" +
               "            \"store\": \"Ricardo Eletro - OUT\",\n" +
               "            \"description\": \"Parcela 10\",\n" +
               "            \"value\": 19.9\n" +
               "        },\n" +
               "        {\n" +
               "            \"date\": \"2018-10-01T00:00:00.000Z\",\n" +
               "            \"store\": \"Ricardo Eletro - OUT\",\n" +
               "            \"description\": \"Parcela 10\",\n" +
               "            \"value\": 19.9\n" +
               "        },\n" +
               "        {\n" +
               "            \"date\": \"2018-10-01T00:00:00.000Z\",\n" +
               "            \"store\": \"Ricardo Eletro - OUT\",\n" +
               "            \"description\": \"Parcela 10\",\n" +
               "            \"value\": 19.9\n" +
               "        },\n" +
               "        {\n" +
               "            \"date\": \"2018-10-01T00:00:00.000Z\",\n" +
               "            \"store\": \"Ricardo Eletro - OUT\",\n" +
               "            \"description\": \"Parcela 10\",\n" +
               "            \"value\": 19.9\n" +
               "        },\n" +
               "        {\n" +
               "            \"date\": \"2018-10-01T00:00:00.000Z\",\n" +
               "            \"store\": \"Ricardo Eletro - OUT\",\n" +
               "            \"description\": \"Parcela 10\",\n" +
               "            \"value\": 19.9\n" +
               "        },\n" +
               "        {\n" +
               "            \"date\": \"2018-10-01T00:00:00.000Z\",\n" +
               "            \"store\": \"Ricardo Eletro - OUT\",\n" +
               "            \"description\": \"Parcela 10\",\n" +
               "            \"value\": 19.9\n" +
               "        },\n" +
               "        {\n" +
               "            \"date\": \"2018-10-01T00:00:00.000Z\",\n" +
               "            \"store\": \"Ricardo Eletro - OUT\",\n" +
               "            \"description\": \"Parcela 10\",\n" +
               "            \"value\": 19.9\n" +
               "        }\n" +
               "    ],\n" +
               "    \"lastPage\": \"10\"\n" +
               "}", ExtratoVO.class);

        return extratoVO;
    }




}
