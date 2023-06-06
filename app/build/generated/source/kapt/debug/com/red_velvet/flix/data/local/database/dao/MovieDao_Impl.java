package com.red_velvet.flix.data.local.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.red_velvet.flix.data.local.database.entity.NowPlayingMovieDto;
import com.red_velvet.flix.data.local.database.entity.PopularMovieDto;
import com.red_velvet.flix.data.local.database.entity.TopRatedMovieDto;
import com.red_velvet.flix.data.local.database.entity.UpcomingMovieDto;
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
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class MovieDao_Impl implements MovieDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PopularMovieDto> __insertionAdapterOfPopularMovieEntity;

  private final EntityInsertionAdapter<TopRatedMovieDto> __insertionAdapterOfTopRatedMovieEntity;

  private final EntityInsertionAdapter<NowPlayingMovieDto> __insertionAdapterOfNowPlayingMovieEntity;

  private final EntityInsertionAdapter<UpcomingMovieDto> __insertionAdapterOfUpcomingMovieEntity;

  public MovieDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPopularMovieEntity = new EntityInsertionAdapter<PopularMovieDto>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `POPULAR_MOVIES` (`id`,`title`,`originalLanguage`,`overview`,`imageUrl`,`date`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PopularMovieDto value) {
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
      }
    };
    this.__insertionAdapterOfTopRatedMovieEntity = new EntityInsertionAdapter<TopRatedMovieDto>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `TOP_RATED_MOVIES` (`id`,`title`,`originalLanguage`,`overview`,`imageUrl`,`date`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TopRatedMovieDto value) {
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
      }
    };
    this.__insertionAdapterOfNowPlayingMovieEntity = new EntityInsertionAdapter<NowPlayingMovieDto>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `NOW_PLAYING_MOVIES` (`id`,`title`,`originalLanguage`,`overview`,`imageUrl`,`date`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, NowPlayingMovieDto value) {
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
      }
    };
    this.__insertionAdapterOfUpcomingMovieEntity = new EntityInsertionAdapter<UpcomingMovieDto>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `UPCOMING_MOVIES` (`id`,`title`,`originalLanguage`,`overview`,`imageUrl`,`date`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, UpcomingMovieDto value) {
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
      }
    };
  }

  @Override
  public Object insertPopularMovies(final List<PopularMovieDto> popularMovieEntities,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPopularMovieEntity.insert(popularMovieEntities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object insertTopRatedMovies(final List<TopRatedMovieDto> topRatedMovieEntities,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTopRatedMovieEntity.insert(topRatedMovieEntities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object insertNowPlayingMovies(final List<NowPlayingMovieDto> nowPlayingMovieEntities,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfNowPlayingMovieEntity.insert(nowPlayingMovieEntities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object insertUpcomingMovies(final List<UpcomingMovieDto> upcomingMovieEntities,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUpcomingMovieEntity.insert(upcomingMovieEntities);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<PopularMovieDto>> getPopularMovies() {
    final String _sql = "SELECT * FROM POPULAR_MOVIES";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"POPULAR_MOVIES"}, new Callable<List<PopularMovieDto>>() {
      @Override
      public List<PopularMovieDto> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfOriginalLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "originalLanguage");
          final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final List<PopularMovieDto> _result = new ArrayList<PopularMovieDto>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final PopularMovieDto _item;
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
            _item = new PopularMovieDto(_tmpId,_tmpTitle,_tmpOriginalLanguage,_tmpOverview,_tmpImageUrl,_tmpDate);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<TopRatedMovieDto>> getTopRatedMovies() {
    final String _sql = "SELECT * FROM TOP_RATED_MOVIES";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"TOP_RATED_MOVIES"}, new Callable<List<TopRatedMovieDto>>() {
      @Override
      public List<TopRatedMovieDto> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfOriginalLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "originalLanguage");
          final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final List<TopRatedMovieDto> _result = new ArrayList<TopRatedMovieDto>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final TopRatedMovieDto _item;
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
            _item = new TopRatedMovieDto(_tmpId,_tmpTitle,_tmpOriginalLanguage,_tmpOverview,_tmpImageUrl,_tmpDate);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<NowPlayingMovieDto>> getNowPlayingMovies() {
    final String _sql = "SELECT * FROM NOW_PLAYING_MOVIES";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"NOW_PLAYING_MOVIES"}, new Callable<List<NowPlayingMovieDto>>() {
      @Override
      public List<NowPlayingMovieDto> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfOriginalLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "originalLanguage");
          final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final List<NowPlayingMovieDto> _result = new ArrayList<NowPlayingMovieDto>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final NowPlayingMovieDto _item;
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
            _item = new NowPlayingMovieDto(_tmpId,_tmpTitle,_tmpOriginalLanguage,_tmpOverview,_tmpImageUrl,_tmpDate);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<UpcomingMovieDto>> getUpcomingMovies() {
    final String _sql = "SELECT * FROM UPCOMING_MOVIES";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"UPCOMING_MOVIES"}, new Callable<List<UpcomingMovieDto>>() {
      @Override
      public List<UpcomingMovieDto> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfOriginalLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "originalLanguage");
          final int _cursorIndexOfOverview = CursorUtil.getColumnIndexOrThrow(_cursor, "overview");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageUrl");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final List<UpcomingMovieDto> _result = new ArrayList<UpcomingMovieDto>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final UpcomingMovieDto _item;
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
            _item = new UpcomingMovieDto(_tmpId,_tmpTitle,_tmpOriginalLanguage,_tmpOverview,_tmpImageUrl,_tmpDate);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
