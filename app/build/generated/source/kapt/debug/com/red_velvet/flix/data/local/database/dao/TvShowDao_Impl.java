package com.red_velvet.flix.data.local.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.red_velvet.flix.data.local.database.entity.AiringTodaySeriesDto;
import com.red_velvet.flix.data.local.database.entity.OnTheAirSeriesDto;
import com.red_velvet.flix.data.local.database.entity.PopularSeriesDto;
import com.red_velvet.flix.data.local.database.entity.TopRatedSeriesDto;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class TvShowDao_Impl implements SeriesDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PopularSeriesDto> __insertionAdapterOfPopularTvShowEntity;

  private final EntityInsertionAdapter<TopRatedSeriesDto> __insertionAdapterOfTopRatedTvShowEntity;

  private final EntityInsertionAdapter<OnTheAirSeriesDto> __insertionAdapterOfOnTheAirTvShowEntity;

  private final EntityInsertionAdapter<AiringTodaySeriesDto> __insertionAdapterOfAiringTodayTvShowEntity;

  public TvShowDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPopularTvShowEntity = new EntityInsertionAdapter<PopularSeriesDto>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `POPULAR_SERIES` (`id`,`title`,`originalLanguage`,`overview`,`imageUrl`,`date`,`popularity`,`voteAverage`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PopularSeriesDto value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getOriginalLanguage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getOriginalLanguage());
        }
        if (value.getOverview() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOverview());
        }
        if (value.getImageUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getImageUrl());
        }
        if (value.getDate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDate());
        }
        stmt.bindDouble(7, value.getPopularity());
        stmt.bindDouble(8, value.getVoteAverage());
      }
    };
    this.__insertionAdapterOfTopRatedTvShowEntity = new EntityInsertionAdapter<TopRatedSeriesDto>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `TOP_RATED_SERIES` (`id`,`title`,`originalLanguage`,`overview`,`imageUrl`,`date`,`popularity`,`voteAverage`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TopRatedSeriesDto value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getOriginalLanguage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getOriginalLanguage());
        }
        if (value.getOverview() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOverview());
        }
        if (value.getImageUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getImageUrl());
        }
        if (value.getDate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDate());
        }
        stmt.bindDouble(7, value.getPopularity());
        stmt.bindDouble(8, value.getVoteAverage());
      }
    };
    this.__insertionAdapterOfOnTheAirTvShowEntity = new EntityInsertionAdapter<OnTheAirSeriesDto>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `ON_THE_AIR_SERIES` (`id`,`title`,`originalLanguage`,`overview`,`imageUrl`,`date`,`popularity`,`voteAverage`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, OnTheAirSeriesDto value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getOriginalLanguage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getOriginalLanguage());
        }
        if (value.getOverview() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOverview());
        }
        if (value.getImageUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getImageUrl());
        }
        if (value.getDate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDate());
        }
        stmt.bindDouble(7, value.getPopularity());
        stmt.bindDouble(8, value.getVoteAverage());
      }
    };
    this.__insertionAdapterOfAiringTodayTvShowEntity = new EntityInsertionAdapter<AiringTodaySeriesDto>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `AIRING_TODAY_SERIES` (`id`,`title`,`originalLanguage`,`overview`,`imageUrl`,`date`,`popularity`,`voteAverage`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, AiringTodaySeriesDto value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getOriginalLanguage() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getOriginalLanguage());
        }
        if (value.getOverview() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOverview());
        }
        if (value.getImageUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getImageUrl());
        }
        if (value.getDate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDate());
        }
        stmt.bindDouble(7, value.getPopularity());
        stmt.bindDouble(8, value.getVoteAverage());
      }
    };
  }

  @Override
  public Object insertPopularTvShows(final List<PopularSeriesDto> popularTvShowEntities,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPopularTvShowEntity.insert(popularTvShowEntities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object insertTopRatedTvShows(final List<TopRatedSeriesDto> topRatedTvShowEntities,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTopRatedTvShowEntity.insert(topRatedTvShowEntities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object insertOnTheAirTvShows(final List<OnTheAirSeriesDto> onTheAirTvShowEntities,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfOnTheAirTvShowEntity.insert(onTheAirTvShowEntities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object insertAiringTodayTvShows(
      final List<AiringTodaySeriesDto> airingTodayTvShowEntities,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfAiringTodayTvShowEntity.insert(airingTodayTvShowEntities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public List<PopularSeriesDto> getPopularSeries() {
    final String _sql = "SELECT * FROM POPULAR_SERIES";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfOriginalLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "originalLanguage");
      final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
      final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "popularity");
      final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(_cursor, "voteAverage");
      final List<PopularSeriesDto> _result = new ArrayList<PopularSeriesDto>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final PopularSeriesDto _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        final String _tmpOriginalLanguage;
        if (_cursor.isNull(_cursorIndexOfOriginalLanguage)) {
          _tmpOriginalLanguage = null;
        } else {
          _tmpOriginalLanguage = _cursor.getString(_cursorIndexOfOriginalLanguage);
        }
        final String _tmpOverview;
        if (_cursor.isNull(_cursorIndexOfOverview)) {
          _tmpOverview = null;
        } else {
          _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
        }
        final String _tmpImageUrl;
        if (_cursor.isNull(_cursorIndexOfImageUrl)) {
          _tmpImageUrl = null;
        } else {
          _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
        }
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        final double _tmpPopularity;
        _tmpPopularity = _cursor.getDouble(_cursorIndexOfPopularity);
        final double _tmpVoteAverage;
        _tmpVoteAverage = _cursor.getDouble(_cursorIndexOfVoteAverage);
        _item = new PopularSeriesDto(_tmpId,_tmpTitle,_tmpOriginalLanguage,_tmpOverview,_tmpImageUrl,_tmpDate,_tmpPopularity,_tmpVoteAverage);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<TopRatedSeriesDto> getTopRatedSeries() {
    final String _sql = "SELECT * FROM TOP_RATED_SERIES";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfOriginalLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "originalLanguage");
      final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
      final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "popularity");
      final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(_cursor, "voteAverage");
      final List<TopRatedSeriesDto> _result = new ArrayList<TopRatedSeriesDto>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final TopRatedSeriesDto _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        final String _tmpOriginalLanguage;
        if (_cursor.isNull(_cursorIndexOfOriginalLanguage)) {
          _tmpOriginalLanguage = null;
        } else {
          _tmpOriginalLanguage = _cursor.getString(_cursorIndexOfOriginalLanguage);
        }
        final String _tmpOverview;
        if (_cursor.isNull(_cursorIndexOfOverview)) {
          _tmpOverview = null;
        } else {
          _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
        }
        final String _tmpImageUrl;
        if (_cursor.isNull(_cursorIndexOfImageUrl)) {
          _tmpImageUrl = null;
        } else {
          _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
        }
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        final double _tmpPopularity;
        _tmpPopularity = _cursor.getDouble(_cursorIndexOfPopularity);
        final double _tmpVoteAverage;
        _tmpVoteAverage = _cursor.getDouble(_cursorIndexOfVoteAverage);
        _item = new TopRatedSeriesDto(_tmpId,_tmpTitle,_tmpOriginalLanguage,_tmpOverview,_tmpImageUrl,_tmpDate,_tmpPopularity,_tmpVoteAverage);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<OnTheAirSeriesDto> getOnTheAirSeries() {
    final String _sql = "SELECT * FROM ON_THE_AIR_SERIES";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfOriginalLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "originalLanguage");
      final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
      final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "popularity");
      final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(_cursor, "voteAverage");
      final List<OnTheAirSeriesDto> _result = new ArrayList<OnTheAirSeriesDto>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final OnTheAirSeriesDto _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        final String _tmpOriginalLanguage;
        if (_cursor.isNull(_cursorIndexOfOriginalLanguage)) {
          _tmpOriginalLanguage = null;
        } else {
          _tmpOriginalLanguage = _cursor.getString(_cursorIndexOfOriginalLanguage);
        }
        final String _tmpOverview;
        if (_cursor.isNull(_cursorIndexOfOverview)) {
          _tmpOverview = null;
        } else {
          _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
        }
        final String _tmpImageUrl;
        if (_cursor.isNull(_cursorIndexOfImageUrl)) {
          _tmpImageUrl = null;
        } else {
          _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
        }
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        final double _tmpPopularity;
        _tmpPopularity = _cursor.getDouble(_cursorIndexOfPopularity);
        final double _tmpVoteAverage;
        _tmpVoteAverage = _cursor.getDouble(_cursorIndexOfVoteAverage);
        _item = new OnTheAirSeriesDto(_tmpId,_tmpTitle,_tmpOriginalLanguage,_tmpOverview,_tmpImageUrl,_tmpDate,_tmpPopularity,_tmpVoteAverage);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<AiringTodaySeriesDto> getAiringTodaySeries() {
    final String _sql = "SELECT * FROM AIRING_TODAY_SERIES";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfOriginalLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "originalLanguage");
      final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
      final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfPopularity = CursorUtil.getColumnIndexOrThrow(_cursor, "popularity");
      final int _cursorIndexOfVoteAverage = CursorUtil.getColumnIndexOrThrow(_cursor, "voteAverage");
      final List<AiringTodaySeriesDto> _result = new ArrayList<AiringTodaySeriesDto>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final AiringTodaySeriesDto _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        final String _tmpOriginalLanguage;
        if (_cursor.isNull(_cursorIndexOfOriginalLanguage)) {
          _tmpOriginalLanguage = null;
        } else {
          _tmpOriginalLanguage = _cursor.getString(_cursorIndexOfOriginalLanguage);
        }
        final String _tmpOverview;
        if (_cursor.isNull(_cursorIndexOfOverview)) {
          _tmpOverview = null;
        } else {
          _tmpOverview = _cursor.getString(_cursorIndexOfOverview);
        }
        final String _tmpImageUrl;
        if (_cursor.isNull(_cursorIndexOfImageUrl)) {
          _tmpImageUrl = null;
        } else {
          _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
        }
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        final double _tmpPopularity;
        _tmpPopularity = _cursor.getDouble(_cursorIndexOfPopularity);
        final double _tmpVoteAverage;
        _tmpVoteAverage = _cursor.getDouble(_cursorIndexOfVoteAverage);
        _item = new AiringTodaySeriesDto(_tmpId,_tmpTitle,_tmpOriginalLanguage,_tmpOverview,_tmpImageUrl,_tmpDate,_tmpPopularity,_tmpVoteAverage);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
