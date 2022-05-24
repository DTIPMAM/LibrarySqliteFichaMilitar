package com.example.librarysqlitefichamilitar.classes_dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import com.example.librarysqlitefichamilitar.classes_vo.GrauInstrucaoVO;
import com.example.librarysqlitefichamilitar.database.DBFichaMilitarHelper;


public class GrauInstrucaoDAO {

    private final Context ctx;
    private final String table_name = "pessoas_grau_instrucao";
    private final String[] colunas    = new String[]{"_id","id_pessoa","grauInstrucao"};

    public GrauInstrucaoDAO(Context ctx) {
        this.ctx = ctx;
    }
    public boolean insert(GrauInstrucaoVO vo) {
        SQLiteDatabase db   = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_pessoa",vo.getId_pessoa());
        values.put("grauInstrucao",vo.getGrauInstrucao());
        if(db.insert(table_name, null, values) > 0){
            db.close();
            return true;
        }else{
            return false;
        } }

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
    public String buscarGrauInstrucao(String IdPessoa) {
         String retorn ="";
        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        String[] busca = new String[]{IdPessoa};
        Cursor c = db.query(table_name, colunas, "id_pessoa = ?", busca, null, null, null, null);
      if (c == null) {
            c.close();
            db.close();
        } else if (!c.moveToFirst()) {
            c.close();
            db.close();
        } else {
          retorn = (c.getString(2) != null)?c.getString(2):"";
          c.close();
          db.close();
      }

        return retorn;
    }
    public boolean update(GrauInstrucaoVO vo , String cod) {

        SQLiteDatabase db     = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("grauInstrucao",vo.getGrauInstrucao());
        if(db.update(table_name, values, "id_pessoa = ?", new String[]{cod}) > 0){
            db.close();
            return true;
        }else{
            return false;
        } }


    public int tamDb() {
        SQLiteDatabase db     = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        Cursor cursor = db.query(table_name, colunas, null, null, null, null, null);
        return cursor.getCount();
    }
    public List<GrauInstrucaoVO> lista(String codigo) {

        List<GrauInstrucaoVO> lista = new ArrayList<GrauInstrucaoVO>();
        try {
            SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
            Cursor c  = db.query(table_name, colunas, "token = ?", new String[]{codigo}, null, null, null);

            while (c.moveToNext()) {
                GrauInstrucaoVO vo = new GrauInstrucaoVO();
                vo.setId_pessoa(c.getInt(c.getColumnIndex("id_pessoa")));
                vo.setGrauInstrucao(c.getString(c.getColumnIndex("grauInstrucao")));
                lista.add(vo);

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean deletaitem(String num) {
        boolean excluir = false;
        SQLiteDatabase db    = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        if(db.delete(table_name, "id_pessoa = ?", new String[]{num}) > 0){
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

}
