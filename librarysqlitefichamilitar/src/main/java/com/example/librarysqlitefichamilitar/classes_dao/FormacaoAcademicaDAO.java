package com.example.librarysqlitefichamilitar.classes_dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import com.example.librarysqlitefichamilitar.classes_vo.FormacaoAcademicaVO;
import com.example.librarysqlitefichamilitar.database.DBFichaMilitarHelper;

import static com.example.librarysqlitefichamilitar.util.Util.Tag;


public class FormacaoAcademicaDAO {

    private final Context ctx;
    private final String table_name = "pessoas_formacao_academica";
    private final String[] colunas = new String[]{"_id", "id_pessoa", "area", "nome_curso",
            "instituicao", "finl", "carga_horaria", "completo"};

    public FormacaoAcademicaDAO(Context ctx) {
        this.ctx = ctx;
    }

    public boolean insert(FormacaoAcademicaVO vo) {
        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_id", vo.getId());
        values.put("id_pessoa", vo.getId_pessoa());
        values.put("area", vo.getArea());
        values.put("nome_curso", vo.getNome_curso());
        values.put("instituicao", vo.getInstituicao());
        values.put("finl", vo.getFinl());
        values.put("carga_horaria", vo.getCarga_horaria());
        values.put("completo", vo.getCompleto());
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

    public Cursor buscarid_pessoa(String id_pessoa) {

        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        String[] busca = new String[]{id_pessoa};
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
        return c;

    }

    public boolean update(FormacaoAcademicaVO vo, String cod) {

        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_pessoa", vo.getId_pessoa());
        values.put("area", vo.getArea());
        values.put("nome_curso", vo.getNome_curso());
        values.put("instituicao", vo.getInstituicao());
        values.put("finl", vo.getFinl());
        values.put("carga_horaria", vo.getCarga_horaria());
        values.put("completo", vo.getCompleto());
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

    public ArrayList<FormacaoAcademicaVO> getListaVO(String id_pessoa) {

        ArrayList<FormacaoAcademicaVO> listaVO = new ArrayList<>();
        try {
            SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
            Cursor c = db.query(table_name, colunas, "id_pessoa = ?", new String[]{id_pessoa}, null, null, null);

            if (c == null) {
                Tag(ctx, " Cursor  = null"  );
                return null;

            } else if (!c.moveToFirst()) {
                c.close();
                Tag(ctx, " Cursor  = null"  );
                return null;
            }
            Tag(ctx, " Cursor  = " + c.getCount() + " Cursor  = " + c.getPosition());

           do{
                FormacaoAcademicaVO vo = new FormacaoAcademicaVO();
                vo.setId(c.getInt(c.getColumnIndex("_id")));
                vo.setId_pessoa(c.getInt(c.getColumnIndex("id_pessoa")));
                vo.setArea(c.getString(c.getColumnIndex("area")));
                vo.setNome_curso(c.getString(c.getColumnIndex("nome_curso")));
                vo.setInstituicao(c.getString(c.getColumnIndex("instituicao")));
                vo.setFinl(c.getString(c.getColumnIndex("finl")));
                vo.setCarga_horaria(c.getString(c.getColumnIndex("carga_horaria")));
                vo.setCompleto(c.getString(c.getColumnIndex("completo")));
                listaVO.add(vo);

            }while (c.moveToNext());
            c.close();
            db.close();
            return listaVO;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean VerificaSeTemIdBD_Local(String codescala) {

        boolean tiporetorn = false;
        try {
            SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();

            String[] busca = new String[]{codescala};

            Cursor c = db.query(table_name, colunas, "_id = ?", busca, null, null, null, null);
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
