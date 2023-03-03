package com.example.librarysqlitefichamilitar.classes_dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.librarysqlitefichamilitar.classes_vo.DeclaracaoPatrimonioVO;
import com.example.librarysqlitefichamilitar.classes_vo.DeclaracaoPatrimonioVO;
import com.example.librarysqlitefichamilitar.database.DBFichaMilitarHelper;

import java.util.ArrayList;

public class DeclaracaoPatrimonioDAO {

    private final Context ctx;
    private final String table_name = "declaracao_patrimonio";
    private final String[] colunas = new String[]{
            "_id", "id_bens", "id_pessoa", "ci",
            "nome", "status", "data_inicio", "data_termino",
            "mensagem"};

    public DeclaracaoPatrimonioDAO(Context ctx) {
        this.ctx = ctx;
    }
    

    public boolean insert(DeclaracaoPatrimonioVO vo) {
        boolean tiporetorn = false;
        SQLiteDatabase db   = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_bens",vo.getId_bens());
        values.put("id_pessoa",vo.getId_pessoa());
        values.put("valor_bem", vo.getValor_bem());
        values.put("apresentou_decla_bens", vo.getApresentou_decla_bens());
        values.put("acumula_cargo_funcao", vo.getAcumula_cargo_funcao());
        values.put("descr", vo.getDescr());
        values.put("observacoes", vo.getObservacoes());
        if(db.insert(table_name, null, values) > 0){
            db.close();
            tiporetorn = true;
        } else {
            tiporetorn = false;
        }
        return tiporetorn;
    }

    @SuppressLint("Range")
    public ArrayList<DeclaracaoPatrimonioVO> getListaVO(String id_pessoa) {

        ArrayList<DeclaracaoPatrimonioVO> lista = new ArrayList<DeclaracaoPatrimonioVO>();
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
                DeclaracaoPatrimonioVO vo = new DeclaracaoPatrimonioVO();
                vo.setId_bens(c.getInt(c.getColumnIndex("id_bens")));
                vo.setId_pessoa(c.getInt(c.getColumnIndex("id_pessoa")));
                vo.setValor_bem(c.getInt(c.getColumnIndex("valor_bem")));
                vo.setApresentou_decla_bens(c.getString(c.getColumnIndex("apresentou_decla_bens")));
                vo.setAcumula_cargo_funcao(c.getString(c.getColumnIndex("acumula_cargo_funcao")));
                vo.setDescr(c.getString(c.getColumnIndex("descr")));
                vo.setObservacoes(c.getString(c.getColumnIndex("observacoes")));
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
    public boolean update(DeclaracaoPatrimonioVO vo , String cod) {

        SQLiteDatabase db     = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_pessoa",vo.getId_pessoa());
        values.put("id_bens",vo.getId_bens());
        values.put("valor_bem",vo.getValor_bem());
        values.put("apresentou_decla_bens",vo.getApresentou_decla_bens());
        values.put("acumula_cargo_funcao",vo.getAcumula_cargo_funcao());
        values.put("descr",vo.getDescr());
        values.put("observacoes",vo.getObservacoes());
        
        if(db.update(table_name, values, "_id = ?", new String[]{cod}) > 0){
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
        if(db.delete(table_name, "_id = ?", new String[]{num}) > 0){
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

            Cursor c = db.query(table_name, colunas, "_id = ?", busca, null, null, null, null);
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
