package com.mykits.dao.base;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface BaseDao<E,PK extends Serializable> {

    int countByPK(PK id);
	
    int countByExample(BaseIbatis3Example example);

    int deleteByExample(BaseIbatis3Example example);

    int deleteByPK(PK id);

    int insert(E record);
    
    int batchInsert(List<E> records);

    int insertSelective(E record);

    List<E> findByExample(RowBounds rowBounds,BaseIbatis3Example example);
    List<E> findByExample(BaseIbatis3Example example);
    
    List<E> findAll(RowBounds rowBounds);
    List<E> findAll();
    
	E getByPK(PK pk);
    
    int updateByExampleSelective(@Param("record") E record, @Param("example") BaseIbatis3Example example);

    int updateByExample(@Param("record") E record, @Param("example") BaseIbatis3Example example);

    int updateByPKSelective(@Param("record")E record);

    int updateByPK(@Param("record")E record);
    
    Date getDatabaseTime();
}
