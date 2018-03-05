package com.spring.recomendmovie.utils.mapper;

import com.spring.recomendmovie.utils.Table;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;



import java.util.ArrayList;

public interface ObjMapper<T> {
    @SelectProvider(type = DynaSqlProvider.class, method = "selectWithParam")
    ArrayList<T> getObjWithParams(Table table);

    @InsertProvider(type = DynaSqlProvider.class, method =  "insertWithParam")
    int addObjWithParams(Table table);

    @DeleteProvider(type = DynaSqlProvider.class, method = "deleteWithParam")
    int deleteObjWithParams(Table table);

    @UpdateProvider(type = DynaSqlProvider.class, method = "updateWithParam")
    int updateObjWirhParams(Table table);
}
