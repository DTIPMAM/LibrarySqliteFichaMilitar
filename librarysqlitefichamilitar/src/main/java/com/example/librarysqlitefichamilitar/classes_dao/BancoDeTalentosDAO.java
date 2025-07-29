package com.example.librarysqlitefichamilitar.classes_dao;

import static com.example.librarysqlitefichamilitar.util.Util.Tag;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.librarysqlitefichamilitar.classes_vo.BancoDeTalentosVO;
import com.example.librarysqlitefichamilitar.database.DBFichaMilitarHelper;

import java.util.ArrayList;

public class BancoDeTalentosDAO {

    private final Context ctx;
    private final String table_name = "pessoas_banco_talento";
    private final String[] colunas = new String[]{
            "_id", "id_tipo_curso_academico", "id_pessoa", "id_banco_talentos",
            "id_instituicao_ensino", "nome_curso", "inicio", "final",
            "completo", "modalidade", "carga_horaria"};

    public BancoDeTalentosDAO(Context ctx) {
        this.ctx = ctx;
    }
    

    public boolean insert(BancoDeTalentosVO vo) {
        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_id", vo.getId());
        values.put("id_tipo_curso_academico",vo.getId_tipo_curso_academico());
        values.put("id_pessoa",vo.getId_pessoa());
        values.put("id_banco_talentos",vo.getId_banco_talentos());
        values.put("id_instituicao_ensino",vo.getId_instituicao_ensino());
        values.put("nome_curso",vo.getNome_curso());
        values.put("inicio",vo.getInicio_data());
        values.put("final",vo.getFinal_data());
        values.put("completo",vo.getCompleto());
        values.put("modalidade",vo.getModalidade());
        values.put("carga_horaria",vo.getCarga_horaria());
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

    public boolean update(BancoDeTalentosVO vo , String cod) {

        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id_tipo_curso_academico",vo.getId_tipo_curso_academico());
        values.put("id_pessoa",vo.getId_pessoa());
        values.put("id_banco_talentos",vo.getId_banco_talentos());
        values.put("id_instituicao_ensino",vo.getId_instituicao_ensino());
        values.put("nome_curso",vo.getNome_curso());
        values.put("inicio",vo.getInicio_data());
        values.put("final",vo.getFinal_data());
        values.put("completo",vo.getCompleto());
        values.put("modalidade",vo.getModalidade());
        values.put("carga_horaria",vo.getCarga_horaria());
        if (db.update(table_name, values, "_id = ?", new String[]{cod}) > 0) {
            db.close();
            return true;
        } else {
            return false;
        }
    }

 
    public ArrayList<BancoDeTalentosVO> getListaVO(String id_pessoa) {

        ArrayList<BancoDeTalentosVO> lista = new ArrayList<BancoDeTalentosVO>();
        try {
            SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
            Cursor c = db.query(table_name, colunas, "id_pessoa = ?", new String[]{id_pessoa}, null, null, null);
            if (c == null) {
//                Tag(ctx, " Cursor  = null"  );
                return null;

            } else if (!c.moveToFirst()) {
                c.close();
                Tag(ctx, " Cursor  = null"  );
                return null;
            }
            Tag(ctx, " Cursor  = " + c.getCount() + " Cursor  = " + c.getPosition());
            do {
                BancoDeTalentosVO vo = new BancoDeTalentosVO();
                vo.setId(c.getInt(c.getColumnIndexOrThrow("_id")));
                vo.setId_tipo_curso_academico(c.getInt(c.getColumnIndexOrThrow("id_tipo_curso_academico")));
                vo.setId_pessoa(c.getInt(c.getColumnIndexOrThrow("id_pessoa")));
                vo.setId_banco_talentos(c.getInt(c.getColumnIndexOrThrow("id_banco_talentos")));
                vo.setId_instituicao_ensino(c.getInt(c.getColumnIndexOrThrow("id_instituicao_ensino")));
                vo.setNome_curso(c.getString(c.getColumnIndexOrThrow("nome_curso")));
                vo.setInicio_data(c.getString(c.getColumnIndexOrThrow("inicio")));
                vo.setFinal_data(c.getString(c.getColumnIndexOrThrow("final")));
                vo.setCompleto(c.getString(c.getColumnIndexOrThrow("completo")));
                vo.setModalidade(c.getString(c.getColumnIndexOrThrow("modalidade")));
                vo.setCarga_horaria(c.getInt(c.getColumnIndexOrThrow("carga_horaria")));
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




    public boolean deleteall() {
        boolean excluir = false;
        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        excluir = db.delete(table_name, null, null) > 0;
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
        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        excluir = db.delete(table_name, "_id = ?", new String[]{num}) > 0;
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

    public boolean VerificaSeTemIdFB ( String id) {

        boolean tiporetorn = false;
        try {
            SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();

            String[] busca = new String[]{id};

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
