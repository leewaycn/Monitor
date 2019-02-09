package leavesc.hello.monitor.db;

import android.arch.lifecycle.LiveData;
import android.arch.paging.DataSource;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import leavesc.hello.monitor.db.entity.MonitorHttpInformation;

/**
 * 作者：leavesC
 * 时间：2019/2/8 21:02
 * 描述：
 * GitHub：https://github.com/leavesC
 * Blog：https://www.jianshu.com/u/9df45b87cfdf
 */
@Dao
public interface MonitorHttpInformationDao {

    @Insert
    long insert(MonitorHttpInformation model);

    @Update
    void update(MonitorHttpInformation model);

    @Query("SELECT * FROM monitor_httpInformation WHERE id =:id")
    MonitorHttpInformation queryRecord(long id);

    @Query("SELECT * FROM monitor_httpInformation")
    List<MonitorHttpInformation> queryAllRecord();

    @Query("SELECT * FROM monitor_httpInformation order by id desc limit :limit")
    LiveData<List<MonitorHttpInformation>> queryAllRecordObservable(int limit);

    @Query("SELECT * FROM monitor_httpInformation order by id desc")
    LiveData<List<MonitorHttpInformation>> queryAllRecordObservable();

    @Query("SELECT * FROM monitor_httpInformation")
    DataSource.Factory<Integer, MonitorHttpInformation> queryDataSource();

    @Query("DELETE FROM monitor_httpInformation")
    void deleteAll();

}