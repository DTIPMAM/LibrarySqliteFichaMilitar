package com.example.librarysqlitefichamilitar.classes_dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import com.example.librarysqlitefichamilitar.classes_vo.PunicoesVO;
import com.example.librarysqlitefichamilitar.database.DBFichaMilitarHelper;

import static com.example.librarysqlitefichamilitar.util.Util.Tag;


public class PunicoesDAO {

    private final Context ctx;
    private final String table_name = "pessoas_puncoes";
    private final String[] colunas = new String[]{"_id", "id_pessoa", "data_punicao", "descricao_punicao", "data_boletim", "numero_boletim"};

    public PunicoesDAO(Context ctx) {
        this.ctx = ctx;
    }

    public boolean insert(PunicoesVO vo) {
        boolean tiporetorn = false;
        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_id", vo.getId());
        values.put("id_pessoa", vo.getId_pessoa());
        values.put("data_punicao", vo.getData_punicao());
        values.put("descricao_punicao", vo.getDescricao_punicao());
        values.put("data_boletim", vo.getData_boletim());
        values.put("numero_boletim", vo.getNumero_boletim());
        if (db.insert(table_name, null, values) > 0) {
            db.close();
            tiporetorn = true;
        } else {
            tiporetorn = false;
        }
        return tiporetorn;
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

    //-----------------------------------------
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

    public boolean update(PunicoesVO vo, String cod) {

        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_pessoa", vo.getId_pessoa());
        values.put("data_punicao", vo.getData_punicao());
        values.put("descricao_punicao", vo.getDescricao_punicao());
        values.put("data_boletim", vo.getData_boletim());
        values.put("numero_boletim", vo.getNumero_boletim());
        if (db.update(table_name, values, "_id = ?", new String[]{cod}) > 0) {
            db.close();
            return true;
        } else {
            return false;
        }
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

    public boolean VerificaSeTemIdPessoa(String id_pessoa) {

        boolean tiporetorn = false;
        try {
            SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();

            String[] busca = new String[]{id_pessoa};

            Cursor c = db.query(table_name, colunas, "id_pessoa = ?", busca, null, null, null, null);
            if (c.getCount() > 0) {
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

    public ArrayList<PunicoesVO> getListaVO(String id_pessoa) {

        ArrayList<PunicoesVO> lista = new ArrayList<PunicoesVO>();
        try {
            SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
            Cursor c = db.query(table_name, colunas, "id_pessoa = ?", new String[]{id_pessoa}, null, null, null);
            if (c == null) {
                Tag(ctx, " Cursor  = null");
                return null;

            } else if (!c.moveToFirst()) {
                c.close();
                Tag(ctx, " Cursor  = null");
                return null;
            }
            Tag(ctx, " Cursor  = " + c.getCount() + " Cursor  = " + c.getPosition());

            do {
                PunicoesVO vo = new PunicoesVO();
                vo.setId(c.getInt(c.getColumnIndex("_id")));
                vo.setId_pessoa(c.getInt(c.getColumnIndex("id_pessoa")));
                vo.setData_punicao(c.getString(c.getColumnIndex("data_punicao")));
                vo.setDescricao_punicao(c.getString(c.getColumnIndex("descricao_punicao")));
                vo.setData_boletim(c.getString(c.getColumnIndex("data_boletim")));
                vo.setNumero_boletim(c.getString(c.getColumnIndex("numero_boletim")));
                lista.add(vo);

            } while (c.moveToNext());
            c.close();
            db.close();
            return lista;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Cursor buscarCursor(String IdPessoa) {

        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        String[] busca = new String[]{IdPessoa};
        Cursor c = db.query(table_name, colunas, "id_pessoa = ?", busca, null, null, null, null);
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
