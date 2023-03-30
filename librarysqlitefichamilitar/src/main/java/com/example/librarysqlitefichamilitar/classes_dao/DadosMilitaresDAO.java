package com.example.librarysqlitefichamilitar.classes_dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.librarysqlitefichamilitar.classes_vo.DadosMilitaresVO;
import com.example.librarysqlitefichamilitar.database.DBFichaMilitarHelper;


public class DadosMilitaresDAO {

    private final Context ctx;
    private final String table_name = "pessoas_dados_militares";
    private final String[] colunas    = new String[]{"_id","cpf","idt_militar","nome_guerra","antiguidade","data_exp_identidade","Funcao","PostoPatente","PostoQuadro","FuncaoGratificada","comportamento",
            "data_inclusao","bg_inclusao","bg_inclusao_data","data_exclusao","bg_exclusao","bg_exclusao_data","tamanho_calca","tamanho_camisa","tamanho_sapato",
            "tamanho_gorro","tamanho_gandola","tamanho_calca_instrucao","tamanho_canicola","tamanho_calcao_tfm","tamanho_coturno",
            "tamanho_saia","lotacao","status","situacao","data_atualiz","whoupdate", "tempo_servico"};

    public DadosMilitaresDAO(Context ctx) {
        this.ctx = ctx;
    }
    public boolean insert(DadosMilitaresVO vo) {
        SQLiteDatabase db   = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_id",vo.getId());
        values.put("cpf",vo.getCpf());
        values.put("idt_militar",vo.getIdt_militar());
        values.put("nome_guerra",vo.getNome_guerra());
        values.put("antiguidade",vo.getAntiguidade());
        values.put("data_exp_identidade",vo.getData_exp_identidade());
        values.put("Funcao",vo.getFuncao());
        values.put("PostoPatente",vo.getPostoPatente());
        values.put("PostoQuadro",vo.getPostoQuadro());
        values.put("FuncaoGratificada",vo.getFuncaoGratificada());
        values.put("comportamento",vo.getComportamento());
        values.put("data_inclusao",vo.getData_inclusao());
        values.put("bg_inclusao",vo.getBg_inclusao());
        values.put("bg_inclusao_data",vo.getBg_inclusao_data());
        values.put("data_exclusao",vo.getData_exclusao());
        values.put("bg_exclusao",vo.getBg_exclusao());
        values.put("bg_exclusao_data",vo.getBg_exclusao_data());
        values.put("tamanho_calca",vo.getTamanho_calca());
        values.put("tamanho_camisa",vo.getTamanho_camisa());
        values.put("tamanho_sapato",vo.getTamanho_sapato());
        values.put("tamanho_gorro",vo.getTamanho_gorro());
        values.put("tamanho_gandola",vo.getTamanho_gandola());
        values.put("tamanho_calca_instrucao",vo.getTamanho_calca_instrucao());
        values.put("tamanho_canicola",vo.getTamanho_canicola());
        values.put("tamanho_calcao_tfm",vo.getTamanho_calcao_tfm());
        values.put("tamanho_coturno",vo.getTamanho_coturno());
        values.put("tamanho_saia",vo.getTamanho_saia());
        values.put("lotacao",vo.getLotacao());
        values.put("status",vo.getStatus());
        values.put("situacao",vo.getSituacao());
        values.put("data_atualiz",vo.getData_atualiz());
        values.put("whoupdate",vo.getWhoupdate());
        values.put("tempo_servico",vo.getTempo_servico());
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
    public boolean update(DadosMilitaresVO vo , String cod) {

        SQLiteDatabase db     = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("cpf",vo.getCpf());
        values.put("idt_militar",vo.getIdt_militar());
        values.put("nome_guerra",vo.getNome_guerra());
        values.put("antiguidade",vo.getAntiguidade());
        values.put("data_exp_identidade",vo.getData_exp_identidade());
        values.put("Funcao",vo.getFuncao());
        values.put("PostoPatente",vo.getPostoPatente());
        values.put("PostoQuadro",vo.getPostoQuadro());
        values.put("FuncaoGratificada",vo.getFuncaoGratificada());
        values.put("comportamento",vo.getComportamento());
        values.put("data_inclusao",vo.getData_inclusao());
        values.put("bg_inclusao",vo.getBg_inclusao());
        values.put("bg_inclusao_data",vo.getBg_inclusao_data());
        values.put("data_exclusao",vo.getData_exclusao());
        values.put("bg_exclusao",vo.getBg_exclusao());
        values.put("bg_exclusao_data",vo.getBg_exclusao_data());
        values.put("tamanho_calca",vo.getTamanho_calca());
        values.put("tamanho_camisa",vo.getTamanho_camisa());
        values.put("tamanho_sapato",vo.getTamanho_sapato());
        values.put("tamanho_gorro",vo.getTamanho_gorro());
        values.put("tamanho_gandola",vo.getTamanho_gandola());
        values.put("tamanho_calca_instrucao",vo.getTamanho_calca_instrucao());
        values.put("tamanho_canicola",vo.getTamanho_canicola());
        values.put("tamanho_calcao_tfm",vo.getTamanho_calcao_tfm());
        values.put("tamanho_coturno",vo.getTamanho_coturno());
        values.put("tamanho_saia",vo.getTamanho_saia());
        values.put("lotacao",vo.getLotacao());
        values.put("status",vo.getStatus());
        values.put("situacao",vo.getSituacao());
        values.put("data_atualiz",vo.getData_atualiz());
        values.put("whoupdate",vo.getWhoupdate());
        values.put("tempo_servico",vo.getTempo_servico());
        if(db.update(table_name, values, "_id = ?", new String[]{cod}) > 0){
            db.close();
            return true;
        }else{
            return false;
        } }

    public boolean update_dadoslotacaodomilitar(DadosMilitaresVO vo , String cod) {

        SQLiteDatabase db   = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("lotacao",vo.getLotacao());

        if(db.update(table_name, values, "_id = ?", new String[]{cod}) > 0){
            db.close();
            return true;
        }else{
            db.close();
            return false;
        } }



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

    public String buscarCI(String CI_CPF_Militar) {
       String ci = "";
        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        String[] busca = new String[]{CI_CPF_Militar};
        Cursor c = db.query(table_name, colunas, "cpf = ? or idt_militar = ?", busca, null, null, null, null);
        if (c == null) {
            c.close();
            db.close();
            return  "";
        } else if (!c.moveToFirst()) {
            c.close();
            db.close();
            return "";
        }
        ci  = c.getString(c.getColumnIndex("idt_militar"));
        c.close();
        db.close();
        return ci;

    }

    public boolean VerificaSeTemIdPessoa ( String id) {

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


    public DadosMilitaresVO getDadosMilitares(String IdPessoa){

        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        String[] busca = new String[]{ IdPessoa};
        Cursor c = db.query(table_name, colunas, "_id = ?", busca, null, null, null, null);
        if (c == null) {
            db.close();
            return null;
        } else if (!c.moveToFirst()) {
            c.close();
            db.close();
            return null;
        }

        DadosMilitaresVO vo = new DadosMilitaresVO();
        vo.setId(c.getInt(c.getColumnIndex("_id")));
        vo.setCpf(c.getString(c.getColumnIndex("cpf")));
        vo.setIdt_militar(c.getString(c.getColumnIndex("idt_militar")));
        vo.setNome_guerra(c.getString(c.getColumnIndex("nome_guerra")));
        vo.setAntiguidade(c.getString(c.getColumnIndex("antiguidade")));
        vo.setData_exp_identidade(c.getString(c.getColumnIndex("data_exp_identidade")));
        vo.setFuncao(c.getString(c.getColumnIndex("Funcao")));
        vo.setPostoPatente(c.getString(c.getColumnIndex("PostoPatente")));
        vo.setPostoQuadro(c.getString(c.getColumnIndex("PostoQuadro")));
        vo.setFuncaoGratificada(c.getString(c.getColumnIndex("FuncaoGratificada")));
        vo.setComportamento(c.getString(c.getColumnIndex("comportamento")));
        vo.setData_inclusao(c.getString(c.getColumnIndex("data_inclusao")));
        vo.setBg_inclusao(c.getString(c.getColumnIndex("bg_inclusao")));
        vo.setBg_inclusao_data(c.getString(c.getColumnIndex("bg_inclusao_data")));
        vo.setData_exclusao(c.getString(c.getColumnIndex("data_exclusao")));
        vo.setBg_exclusao(c.getString(c.getColumnIndex("bg_exclusao")));
        vo.setBg_exclusao_data(c.getString(c.getColumnIndex("bg_exclusao_data")));
        vo.setTamanho_calca(c.getString(c.getColumnIndex("tamanho_calca")));
        vo.setTamanho_camisa(c.getString(c.getColumnIndex("tamanho_camisa")));
        vo.setTamanho_sapato(c.getString(c.getColumnIndex("tamanho_sapato")));
        vo.setTamanho_gorro(c.getString(c.getColumnIndex("tamanho_gorro")));
        vo.setTamanho_gandola(c.getString(c.getColumnIndex("tamanho_gandola")));
        vo.setTamanho_calca_instrucao(c.getString(c.getColumnIndex("tamanho_calca_instrucao")));
        vo.setTamanho_canicola(c.getString(c.getColumnIndex("tamanho_canicola")));
        vo.setTamanho_calcao_tfm(c.getString(c.getColumnIndex("tamanho_calcao_tfm")));
        vo.setTamanho_coturno(c.getString(c.getColumnIndex("tamanho_coturno")));
        vo.setTamanho_saia(c.getString(c.getColumnIndex("tamanho_saia")));
        vo.setData_atualiz(c.getString(c.getColumnIndex("data_atualiz")));
        vo.setWhoupdate(c.getString(c.getColumnIndex("whoupdate")));

        //lotacao
        vo.setLotacao(c.getString(c.getColumnIndex("lotacao")));
        vo.setStatus(c.getString(c.getColumnIndex("status")));
        vo.setSituacao(c.getString(c.getColumnIndex("situacao")));



        //Inclusao e Exclusao
        vo.setBg_inclusao(c.getString(c.getColumnIndex("bg_inclusao")));
        vo.setBg_inclusao_data(c.getString(c.getColumnIndex("bg_inclusao_data")));
        vo.setData_inclusao(c.getString(c.getColumnIndex("data_inclusao")));

        vo.setBg_exclusao(c.getString(c.getColumnIndex("bg_exclusao")));
        vo.setBg_exclusao_data(c.getString(c.getColumnIndex("bg_exclusao_data")));
        vo.setData_exclusao(c.getString(c.getColumnIndex("data_exclusao")));


        c.close();
        db.close();
        return vo;
    }

}
