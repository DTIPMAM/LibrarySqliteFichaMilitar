package com.example.librarysqlitefichamilitar.classes_dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import com.example.librarysqlitefichamilitar.classes_vo.CursosMilitaresVO;
import com.example.librarysqlitefichamilitar.database.DBFichaMilitarHelper;

import static com.example.librarysqlitefichamilitar.util.Util.Tag;


public class CursosMilitaresDAO {

    private Context ctx;
    private String table_name = "pessoas_cursos_militares";
    private String[] colunas    = new String[]{"_id","id_pessoa","tipoCursoMilitar","nome_curso","instituicaoEnsino","inicio","finl","carga_horaria"};

    public CursosMilitaresDAO(Context ctx) {
        this.ctx = ctx;
    }
    public boolean insert(CursosMilitaresVO vo) {
        SQLiteDatabase db   = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_id",vo.getId());
        values.put("id_pessoa",vo.getId_pessoa());
        values.put("tipoCursoMilitar",vo.getTipoCursoMilitar());
        values.put("nome_curso",vo.getNome_curso());
        values.put("instituicaoEnsino",vo.getInstituicaoEnsino());
        values.put("inicio",vo.getInicio());
        values.put("finl",vo.getFinl());
        values.put("carga_horaria",vo.getCarga_horaria());
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
    public boolean update(CursosMilitaresVO vo , String cod) {

        SQLiteDatabase db     = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_pessoa",vo.getId_pessoa());
        values.put("tipoCursoMilitar",vo.getTipoCursoMilitar());
        values.put("nome_curso",vo.getNome_curso());
        values.put("instituicaoEnsino",vo.getInstituicaoEnsino());
        values.put("inicio",vo.getInicio());
        values.put("finl",vo.getFinl());
        values.put("carga_horaria",vo.getCarga_horaria());
        if(db.update(table_name, values, "_id = ?", new String[]{cod}) > 0){
            db.close();
            return true;
        }else{
            return false;
        } }

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

    public ArrayList<CursosMilitaresVO> getListaVO(String id_pessoa) {

        ArrayList<CursosMilitaresVO> lista = new ArrayList<CursosMilitaresVO>();
        try {
            SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
            Cursor c  = db.query(table_name, colunas, "id_pessoa = ?", new String[]{id_pessoa}, null, null, null);
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

                CursosMilitaresVO vo = new CursosMilitaresVO();
                vo.setId(c.getInt(c.getColumnIndex("_id")));
                vo.setId_pessoa(c.getInt(c.getColumnIndex("id_pessoa")));
                vo.setTipoCursoMilitar(c.getString(c.getColumnIndex("tipoCursoMilitar")));
                vo.setNome_curso(c.getString(c.getColumnIndex("nome_curso")));
                vo.setInstituicaoEnsino(c.getString(c.getColumnIndex("instituicaoEnsino")));
                vo.setInicio(c.getString(c.getColumnIndex("inicio")));
                vo.setFinl(c.getString(c.getColumnIndex("finl")));
                vo.setCarga_horaria(c.getString(c.getColumnIndex("carga_horaria")));
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
