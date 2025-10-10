package com.example.librarysqlitefichamilitar.classes_dao;

import static com.example.librarysqlitefichamilitar.util.Util.Tag;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.librarysqlitefichamilitar.classes_vo.ConcessoesVO;
import com.example.librarysqlitefichamilitar.database.DBFichaMilitarHelper;

import java.util.ArrayList;

public class ConcessoesDAO {
    private final Context ctx;
    private final String table_name = "pessoas_concessoes";
    private final String[] colunas = new String[]{
            "_id", "id_pessoa", "inicio", "termino", "numero_dias", "tipo_concessoes", "tipo_boletim_inicio",
            "data_boletim_inicio", "numero_boletim_inicio"
    };

    public ConcessoesDAO(Context ctx) {
        this.ctx = ctx;
    }

    public boolean insert(ConcessoesVO vo) {
        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_id", vo.getId());
        values.put("id_pessoa", vo.getId_pessoa());
        values.put("inicio", vo.getInicio());
        values.put("termino", vo.getTermino());
        values.put("numero_dias", vo.getNumero_dias());
        values.put("tipo_concessoes", vo.getTipo_concessoes());
        values.put("tipo_boletim_inicio", vo.getTipo_boletim_inicio());
        values.put("data_boletim_inicio", vo.getData_boletim_inicio());
        values.put("numero_boletim_inicio", vo.getNumero_boletim_inicio());
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


    public boolean update(ConcessoesVO vo, String cod) {
        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_id", vo.getId());
        values.put("id_pessoa", vo.getId_pessoa());
        values.put("inicio", vo.getInicio());
        values.put("termino", vo.getTermino());
        values.put("numero_dias", vo.getNumero_dias());
        values.put("tipo_concessoes", vo.getTipo_concessoes());
        values.put("tipo_boletim_inicio", vo.getTipo_boletim_inicio());
        values.put("data_boletim_inicio", vo.getData_boletim_inicio());
        values.put("numero_boletim_inicio", vo.getNumero_boletim_inicio());
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


    public boolean VerificaSeTemIdBD_Local(String codescala) { //verificar se vai ser usada
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
            if (c.getCount() >= 1) {
                tiporetorn = true;
            } else {
                tiporetorn = false;
            }
            c.close();
            db.close();
        } catch (Exception e) {
           // e.printStackTrace();
            Log.e("VerificaSeTemIdPessoa", "erro: " + e.getMessage());
        }
        return tiporetorn;
    }


    public ArrayList<ConcessoesVO> getListaVO(String id_pessoa) {
        ArrayList<ConcessoesVO> lista = new ArrayList<ConcessoesVO>();
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
                ConcessoesVO vo = new ConcessoesVO();
                vo.setId(c.getInt(c.getColumnIndexOrThrow("_id")));
                vo.setId_pessoa(c.getInt(c.getColumnIndexOrThrow("id_pessoa")));
                vo.setInicio(c.getString(c.getColumnIndexOrThrow("inicio")));
                vo.setTermino(c.getString(c.getColumnIndexOrThrow("termino")));
                vo.setNumero_dias(c.getInt(c.getColumnIndexOrThrow("numero_dias")));
                vo.setTipo_concessoes(c.getString(c.getColumnIndexOrThrow("tipo_concessoes")));
                vo.setTipo_boletim_inicio(c.getString(c.getColumnIndexOrThrow("tipo_boletim_inicio")));
                vo.setData_boletim_inicio(c.getString(c.getColumnIndexOrThrow("data_boletim_inicio")));
                vo.setNumero_boletim_inicio(c.getInt(c.getColumnIndexOrThrow("numero_boletim_inicio")));
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


    public Cursor buscarCursor(String id) {

        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        String[] busca = new String[]{id};
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
        db.close();
        return c;
    }
}
