package com.example.librarysqlitefichamilitar.classes_dao;

import static com.example.librarysqlitefichamilitar.util.Util.Tag;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.librarysqlitefichamilitar.classes_vo.AverbacoesVO;
import com.example.librarysqlitefichamilitar.classes_vo.ElogiosVO;
import com.example.librarysqlitefichamilitar.database.DBFichaMilitarHelper;

import java.util.ArrayList;

public class AverbacoesDAO {

    private final Context ctx;
    private final String table_name = "historico_averbacoes";
    private final String[] colunas = new String[]{"_id", "idPessoa", "local", "tipo", "numero_dias", "boletim"};

    public AverbacoesDAO(Context ctx) {
        this.ctx = ctx;
    }

    public boolean insert(AverbacoesVO vo) {
        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_id", vo.get_id());
        values.put("idPessoa", vo.getIdPessoa());
        values.put("local", vo.getLocal());
        values.put("tipo", vo.getTipo());
        values.put("numero_dias", vo.getNumero_dias());
        values.put("boletim", vo.getBoletim());
        if (db.insert(table_name, null, values) > 0) {
            db.close();
            return true;
        } else {
            return false;
        }
    }

    public Cursor buscarTudo() {
        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        Cursor c = db.query(table_name, colunas, null, null, null, null, null);
        if (c == null) {
            return null;
        } else if (!c.moveToFirst()) {
            c.close();
            return null;
        }
        return c;
    }

    public Cursor buscarIdMilitar(String token) {

        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        String[] busca = new String[]{token};
        Cursor c = db.query(table_name, colunas, "_id = ?", busca, null, null, null, null);
        if (c == null) {
            c.close();
            db.close();
            return null;
        } else if (!c.moveToFirst()) {
            c.close();
            db.close();
            return null;
        }
        return c;

    }

    public boolean update(AverbacoesVO vo, String cod) {

        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_id", vo.get_id());
        values.put("idPessoa", vo.getIdPessoa());
        values.put("local", vo.getLocal());
        values.put("tipo", vo.getTipo());
        values.put("numero_dias", vo.getNumero_dias());
        values.put("boletim", vo.getBoletim());
        if (db.update(table_name, values, "_id = ?", new String[]{cod}) > 0) {
            db.close();
            return true;
        } else {
            return false;
        }
    }

    public boolean notNull() {
        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        Cursor c = db.query(table_name, colunas, null, null, null, null, null);
        if (c == null) {
            return false;
        } else if (!c.moveToFirst()) {
            c.close();
            return false;
        }
        c.close();
        db.close();
        return true;
    }

    public int tamDb() {
        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        Cursor cursor = db.query(table_name, colunas, null, null, null, null, null);
        return cursor.getCount();
    }

    public boolean deletaitem(String num) {
        boolean excluir = false;
        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        if (db.delete(table_name, "_id = ?", new String[]{num}) > 0) {
            excluir = true;
        } else {
            excluir = false;
        }
        db.close();
        return excluir;
    }

    public boolean deleteall() {
        boolean excluir = false;
        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        if (db.delete(table_name, null, null) > 0) {
            excluir = true;
        } else {
            excluir = false;
        }
        db.close();
        return excluir;
    }

    public boolean VerificaSeTemIdBD_Local(String codescala) {

        boolean tiporetorn = false;
        try {
            SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();

            String[] busca = new String[]{codescala};

            Cursor c = db.query(table_name, colunas, "_id = ?", busca, null, null, null, null);
            if (c.getCount() >= 1) {
                tiporetorn = true;
            } else {
                tiporetorn = false;
            }
            c.close();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tiporetorn;
    }

    public boolean VerificaSeTemIdPessoa(String idPessoa) {

        boolean tiporetorn = false;
        try {
            SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();

            String[] busca = new String[]{idPessoa};

            Cursor c = db.query(table_name, colunas, "idPessoa = ?", busca, null, null, null, null);
            if (c.getCount() >= 1) {
                tiporetorn = true;
            } else {
                tiporetorn = false;
            }
            c.close();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tiporetorn;
    }

    public ArrayList<AverbacoesVO> getListaVO(String idPessoa) {

        ArrayList<AverbacoesVO> lista = new ArrayList<AverbacoesVO>();
        try {
            SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
            Cursor c = db.query(table_name, colunas, "idPessoa = ?", new String[]{idPessoa}, null, null, null);
            if (c == null) {
                Tag(ctx, " Cursor  = null"  );
                return null;

            } else if (!c.moveToFirst()) {
                c.close();
                Tag(ctx, " Cursor  = null"  );
                return null;
            }
            Tag(ctx, " Cursor  = " + c.getCount() + " Cursor  = " + c.getPosition());

            do {
                AverbacoesVO vo = new AverbacoesVO();
                vo.set_id(c.getInt(c.getColumnIndexOrThrow("_id")));
                vo.setIdPessoa(c.getInt(c.getColumnIndexOrThrow("idPessoa")));
                vo.setLocal(c.getString(c.getColumnIndexOrThrow("local")));
                vo.setTipo(c.getString(c.getColumnIndexOrThrow("tipo")));
                vo.setNumero_dias(c.getInt(c.getColumnIndexOrThrow("numero_dias")));
                vo.setBoletim(c.getString(c.getColumnIndexOrThrow("boletim")));
                lista.add(vo);
            }while (c.moveToNext());
            c.close();
            db.close();
            return lista;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Cursor buscarCursor(String idPessoa) {

        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        String[] busca = new String[]{idPessoa};
        Cursor c = db.query(table_name, colunas, "idPessoa = ?", busca, null, null, null, null);
        if (c == null) {
            c.close();
            db.close();
            return null;
        } else if (!c.moveToFirst()) {
            c.close();
            db.close();
            return null;
        }
        db.close();
        return c;

    }
}
