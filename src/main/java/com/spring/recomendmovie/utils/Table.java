package com.spring.recomendmovie.utils;

public class Table {
    //表名
    private String tableName;

    //要操作的属性键
    private String[] k;

    //要操作的属性值
    private String[] v;

    //要查找的cols
    private String[] cols;

    //要搜索的属性键
    private String[] search_k;

    //要搜索的属性值
    private String[] search_v;

    //模糊查询的属性键
    private String[] like_k;

    //模糊查询的属性值
    private String[] like_v;

    public String[] getLike_k() {
        return like_k;
    }

    public void setLike_k(String[] like_k) {
        this.like_k = like_k;
    }

    public String[] getLike_v() {
        return like_v;
    }

    public void setLike_v(String[] like_v) {
        this.like_v = like_v;
    }

    public String[] getSearch_k() {
        return search_k;
    }

    public void setSearch_k(String[] search_k) {
        this.search_k = search_k;
    }

    public String[] getSearch_v() {
        return search_v;
    }

    public void setSearch_v(String[] search_v) {
        this.search_v = search_v;
    }

    //statement
    private String statement;

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }


    public Table(String tableName) {
        this.tableName = tableName;
    }

    public Table(String tableName, String[] cols) {
        this.tableName = tableName;
        this.cols = cols;
    }

    public Table(String tableName, String[] cols, String[] k, String[] v) {
        this.tableName = tableName;
        this.k = k;
        this.v = v;
        this.cols = cols;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String[] getK() {
        return k;
    }

    public void setK(String[] k) {
        this.k = k;
    }

    public String[] getV() {
        return v;
    }

    public void setV(String[] v) {
        this.v = v;
    }

    public String[] getCols() {
        return cols;
    }

    public void setCols(String[] cols) {
        this.cols = cols;
    }

    public Table() {
    }

//    @Override
//    public String toString() {
//        return queryStatement();
//    }

    public String queryStatement(String synax){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SELECT ");

        stringBuffer.append(cols());

        stringBuffer.append(" FROM " + tableName);

        return stringBuffer.append(conditon(synax)).toString();
    }

    private String conditon(String synax){
        StringBuffer stringBuffer = new StringBuffer();
        if(null != k && k.length != 0){
            int end = k.length;
            stringBuffer.append(" WHERE ");
            for (int start = 0; start < end; start++){
                stringBuffer.append(k[start] + " "+ synax +" \'" + v[start] + "\' AND ");
            }
            return stringBuffer.substring(0, stringBuffer.length() - 4);
        }else{
            return stringBuffer.toString();
        }
    }


    private String cols(){
        StringBuffer stringBuffer = new StringBuffer();
        //select cols from table where cols=vals
        if(cols != null && cols.length != 0) {
            for (String col : cols) {
                stringBuffer.append(col + ", ");
            }
            stringBuffer.delete(stringBuffer.length()-2, stringBuffer.length() - 1);
        }else {
            stringBuffer.append("* ");
        }
        return stringBuffer.toString();
    }

    public String deleteStatement(String synax){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DELETE ");

        stringBuffer.append(" FROM " + tableName);

        return stringBuffer.append(conditon(synax)).toString();
    }

    public String updateStatement(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("UPDATE " + tableName + " SET ");
        //"UPDATE USER SET name=#{name}, paswd=#{paswd} WHERE ID = #{id}
        String id = "-1";
        if(null != k && k.length != 0){
            int end = k.length;
            for (int start = 0; start < end; start++){
                if("id".equals(k[start])){
                    id = v[start];
                    continue;
                }
                stringBuffer.append(k[start] + " = \'" + v[start] + "\' , ");
            }
            stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
        }else{
            //报错
            return null;
        }
        stringBuffer.append("WHERE ID = " + id);
        return stringBuffer.toString();
    }

    public String insertStatement(){
        StringBuffer stringBuffer = new StringBuffer();
        //INSERT INTO USER(name, paswd) VALUES (#{name}, #{paswd})
        stringBuffer.append("INSERT INTO " + tableName + "(");

        if(null != k && k.length != 0){
            int end = k.length;
            for (int start = 0; start < end; start++){
                stringBuffer.append(k[start] + ", ");
            }
            stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
            stringBuffer.append(") VALUES (");

            for (int start = 0; start < end; start++){
                stringBuffer.append("\'" + v[start] + "\', ");
            }
            stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length());
            stringBuffer.append(")");
        }else{
            //报错
            return null;
        }

        return stringBuffer.toString();
    }

    public void clear() {
        this.k = null;
        this.v = null;
        this.cols = null;
        this.statement = null;
        this.search_k = null;
        this.search_v = null;
        this.like_k = null;
        this.like_v = null;
    }
}
