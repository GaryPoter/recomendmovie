package com.spring.recomendmovie.utils.mapper;


import com.spring.recomendmovie.utils.Table;
import org.apache.ibatis.jdbc.SQL;



public class DynaSqlProvider {
    public String selectWithParam(Table table){
        return new SQL(){
            {
                if(table.getCols() == null){
                    SELECT("*");
                }else{
                    SELECT((String)table.getCols().toString());
                }
                FROM(table.getTableName());
                if(isValiade(table.getSearch_k())){
                    int k = table.getSearch_k().length;
                    for (int i = 0; i < k; i++){
                        WHERE(table.getSearch_k()[i] + " = '" + table.getSearch_v()[i] + "'" );
                    }
                }

                if(isValiade(table.getLike_k())){
                    int k = table.getLike_k().length;
                    for (int i = 0; i <k ; i++) {
                        WHERE(table.getLike_k()[i] + " like '%" + table.getLike_v()[i] + "%'");
                    }
                }
            }
        }.toString();
    }

    private boolean isValiade(String[] key){
        return (key != null && key.length != 0);
    }


    public String insertWithParam(Table table){
        return new SQL(){
            {
                INSERT_INTO(table.getTableName());
                if(isValiade(table.getK())){
                    int k = table.getK().length;
                    for (int i = 0; i < k; i++){
                        VALUES(table.getK()[i], "'" + table.getV()[i] + "'");
                    }
                }
            }
        }.toString();
    }

    public String updateWithParam(Table table){
        return new SQL(){
            {
                UPDATE(table.getTableName());
                if(isValiade(table.getK())){
                    int k = table.getK().length;
                    for (int i = 0; i < k; i++){
                        SET(table.getK()[i], table.getV()[i]);
                    }
                }
                if(isValiade(table.getSearch_k())){
                    int k = table.getSearch_k().length;
                    for (int i = 0; i < k; i++){
                        WHERE(table.getSearch_k()[i] + " = '" + table.getSearch_v()[i] + "'");
                    }
                }
            }
        }.toString();
    }

    public String deleteWithParam(Table table){
        return new SQL(){
            {
                DELETE_FROM(table.getTableName());
                if(isValiade(table.getSearch_k())){
                    int k = table.getSearch_k().length;
                    for (int i = 0; i < k; i++){
                        WHERE(table.getSearch_k()[i] + " = '" + table.getSearch_v()[i] + "'" );
                    }
                }
            }
        }.toString();
    }
}
