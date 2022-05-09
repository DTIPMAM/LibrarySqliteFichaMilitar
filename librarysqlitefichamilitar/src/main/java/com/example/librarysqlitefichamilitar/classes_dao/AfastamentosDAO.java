package com.example.librarysqlitefichamilitar.classes_dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import com.example.librarysqlitefichamilitar.classes_vo.AfastamentosVO;
import com.example.librarysqlitefichamilitar.database.DBFichaMilitarHelper;


public class AfastamentosDAO {

    private Context ctx;
    private String table_name = "afastamento";
    private String[] colunas    = new String[]{
            "_id", "id_afastamento", "id_pessoa", "ci",
            "nome", "status", "data_inicio", "data_termino",
            "mensagem"};

    public AfastamentosDAO(Context ctx) {
        this.ctx = ctx;
    }
    public boolean insert(AfastamentosVO vo) {
        boolean tiporetorn = false;
        SQLiteDatabase db   = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_afastamento",vo.getId_afastamento());
        values.put("id_pessoa",vo.getId_pessoa());
        values.put("ci", vo.getCi());
        values.put("nome", vo.getNome());
        values.put("status", vo.getStatus());
        values.put("data_inicio", vo.getData_inicio());
        values.put("data_termino", vo.getData_termino());
        values.put("mensagem", vo.getMensagem());
        if(db.insert(table_name, null, values) > 0){
            db.close();
            tiporetorn = true;
        } else {
            tiporetorn = false;
        }
        return tiporetorn;
    }

    public ArrayList<AfastamentosVO> getListaVO(String id_pessoa) {

        ArrayList<AfastamentosVO> lista = new ArrayList<AfastamentosVO>();
        try {
            SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
            Cursor c = db.query(table_name, colunas, "id_pessoa = ?", new String[]{id_pessoa}, null, null, null);
            if (c == null) {
//                Tag(ctx, " Cursor  = null"  );
                return null;

            } else if (!c.moveToFirst()) {
                c.close();
//                Tag(ctx, " Cursor  = null"  );
                return null;
            }
//            Tag(ctx, " Cursor  = " + c.getCount() + " Cursor  = " + c.getPosition());

            do {
                AfastamentosVO vo = new AfastamentosVO();
                vo.setId_afastamento(c.getInt(c.getColumnIndex("id_afastamento")));
                vo.setId_pessoa(c.getInt(c.getColumnIndex("id_pessoa")));
                vo.setCi(c.getString(c.getColumnIndex("ci")));
                vo.setNome(c.getString(c.getColumnIndex("nome")));
                vo.setStatus(c.getInt(c.getColumnIndex("status")));
                vo.setMensagem(c.getString(c.getColumnIndex("mensagem")));
                vo.setData_inicio(c.getString(c.getColumnIndex("data_inicio")));
                vo.setData_termino(c.getString(c.getColumnIndex("data_termino")));
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
        Cursor c = db.query(table_name, colunas, "id_afastamento = ?", busca, null, null, null, null);
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
    public boolean update(AfastamentosVO vo , String cod) {

        SQLiteDatabase db     = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_pessoa",vo.getId_pessoa());
        values.put("data_inicio", vo.getData_inicio());
        values.put("data_termino", vo.getData_termino());
        values.put("nome", vo.getNome());
        values.put("ci", vo.getCi());
        values.put("status", vo.getStatus());
        values.put("mensagem", vo.getMensagem());
        if(db.update(table_name, values, "id_afastamento = ?", new String[]{cod}) > 0){
            db.close();
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteall() {
        boolean excluir = false;
        SQLiteDatabase db    = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        if(db.delete(table_name,null,null) > 0){
            excluir = true;
        }else {
            excluir = false;
        }
        db.close();
        return excluir;
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
        SQLiteDatabase db     = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        Cursor cursor = db.query(table_name, colunas, null, null, null, null, null);
        return cursor.getCount();
    }

    public boolean deletaitem(String num) {
        boolean excluir = false;
        SQLiteDatabase db    = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        if(db.delete(table_name, "id_afastamento = ?", new String[]{num}) > 0){
            excluir = true;
        }else {
            excluir = false;
        }
        db.close();
        return excluir;
    }


    public boolean VerificaSeTemIdBD_Local ( String codescala) {

        boolean tiporetorn = false;
        try {
            SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();

            String[] busca = new String[]{codescala};

            Cursor c = db.query(table_name, colunas, "id_afastamento = ?", busca, null, null, null, null);
            if (c.getCount() >= 1) {
                tiporetorn = true;
            } else {
                tiporetorn = false;
            }
            c.close();
            db.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return tiporetorn;
    }

    public boolean VerificaSeTemIdPessoa ( String id_pessoa) {

        boolean tiporetorn = false;
        try {
            SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();

            String[] busca = new String[]{id_pessoa};

            Cursor c = db.query(table_name, colunas, "id_pessoa = ?", busca, null, null, null, null);
            if (c.getCount() >= 1) {
                tiporetorn = true;
            } else {
                tiporetorn = false;
            }
            c.close();
            db.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return tiporetorn;
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
