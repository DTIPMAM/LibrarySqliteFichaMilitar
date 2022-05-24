package com.example.librarysqlitefichamilitar.classes_dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.librarysqlitefichamilitar.classes_vo.DadosPessoaisVO;
import com.example.librarysqlitefichamilitar.database.DBFichaMilitarHelper;


public class DadosPessoiasDAO {

    private final Context ctx;
    private final String table_name = "pessoas_dados_pessoais";
    private final String[] colunas    = new String[]{"_id","cpf","rg","matricula","data_nasc","nome","nome_pai","nome_mae","naturaldo",
            "cidadenatal","alistmilitar","dsexo","estado_civil","religiao","pis_pasep","ctps_numero","ctps_serie","ctps_uf","nr_titulo",
            "zona","secao","uf","barba","bigode","cabCor","cabTipo","cabTom","cutis","olhosCor","olhostom","Categoria","nro_registro",
            "data_validade","cep","bairro","numero","cidade","estado",
            "logradouro","complemento","telefone_fixo_pessoal","telefone_celular_pessoal1",
            "telefone_celular_pessoal2","telefone_celular_pessoal3","telefone_celular_corporativo",
            "email_institucional","email_pessoal","data_atualiz", "whoupdate"};

    public DadosPessoiasDAO(Context ctx) {
        this.ctx = ctx;
    }
    public boolean insert(DadosPessoaisVO vo) {
        SQLiteDatabase db   = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_id",vo.getId());
        values.put("cpf",vo.getCpf());
        values.put("rg",vo.getRg());
        values.put("matricula",vo.getMatricula());
        values.put("data_nasc",vo.getData_nasc());
        values.put("nome",vo.getNome());
        values.put("nome_pai",vo.getNome_pai());
        values.put("nome_mae",vo.getNome_mae());
        values.put("naturaldo",vo.getNaturaldo());
        values.put("cidadenatal",vo.getCidadenatal());
        values.put("alistmilitar",vo.getAlistmilitar());
        values.put("dsexo",vo.getDsexo());
        values.put("estado_civil",vo.getEstado_civil());
        values.put("religiao",vo.getReligiao());
        values.put("pis_pasep",vo.getPis_pasep());
        values.put("ctps_numero",vo.getCtps_numero());
        values.put("ctps_serie",vo.getCtps_serie());
        values.put("ctps_uf",vo.getCtps_uf());
        values.put("nr_titulo",vo.getNr_titulo());
        values.put("zona",vo.getZona());
        values.put("secao",vo.getSecao());
        values.put("uf",vo.getUf());

        values.put("barba",vo.getBarba());
        values.put("bigode",vo.getBigode());
        values.put("cabCor",vo.getCabCor());
        values.put("cabTipo",vo.getCabTipo());
        values.put("cabTom",vo.getCabTom());
        values.put("cutis",vo.getCutis());
        values.put("olhosCor",vo.getOlhostom());
        values.put("olhostom",vo.getOlhostom());

        values.put("Categoria",vo.getCategoria());
        values.put("nro_registro",vo.getNro_registro());
        values.put("data_validade",vo.getData_validade());
        values.put("cep",vo.getCep());
        values.put("bairro",vo.getBairro());
        values.put("numero",vo.getNumero());
        values.put("cidade",vo.getCidade());
        values.put("estado",vo.getEstado());
        values.put("logradouro",vo.getLogradouro());
        values.put("complemento",vo.getComplemento());
        values.put("telefone_fixo_pessoal",vo.getTelefone_fixo_pessoal());
        values.put("telefone_celular_pessoal1",vo.getTelefone_celular_pessoal1());
        values.put("telefone_celular_pessoal2",vo.getTelefone_celular_pessoal2());
        values.put("telefone_celular_pessoal3",vo.getTelefone_celular_pessoal3());
        values.put("telefone_celular_corporativo",vo.getTelefone_celular_corporativo());
        values.put("email_institucional",vo.getEmail_institucional());
        values.put("email_pessoal",vo.getEmail_pessoal());
        values.put("data_atualiz",vo.getData_atualiz());
        values.put("whoupdate",vo.getUpdate_username());
        if(db.insert(table_name, null, values) > 0){
            db.close();
            return true;
        }else{
            db.close();
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
    public Cursor buscarCursor(String IdPessoa) {

        SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        String[] busca = new String[]{
                IdPessoa};
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


    public DadosPessoaisVO getDadosPessoais(String IdPessoa){

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
        DadosPessoaisVO v = new DadosPessoaisVO();
        v.setCpf(c.getString(c.getColumnIndex("cpf")));
        v.setRg(c.getString(c.getColumnIndex("rg")));
        v.setMatricula(c.getString(c.getColumnIndex("matricula")));
        v.setData_nasc(c.getString(c.getColumnIndex("data_nasc")));
        v.setNome(c.getString(c.getColumnIndex("nome")));
        v.setNome_pai(c.getString(c.getColumnIndex("nome_pai")));
        v.setNome_mae(c.getString(c.getColumnIndex("nome_mae")));
        v.setNaturaldo(c.getString(c.getColumnIndex("naturaldo")));
        v.setCidadenatal(c.getString(c.getColumnIndex("cidadenatal")));
        v.setAlistmilitar(c.getString(c.getColumnIndex("alistmilitar")));
        v.setDsexo(c.getString(c.getColumnIndex("dsexo")));
        v.setEstado_civil(c.getString(c.getColumnIndex("estado_civil")));
        v.setReligiao(c.getString(c.getColumnIndex("religiao")));
        v.setCep(c.getString(c.getColumnIndex("cep")));
        v.setEstado(c.getString(c.getColumnIndex("estado")));
        v.setCidade(c.getString(c.getColumnIndex("cidade")));
        v.setBairro(c.getString(c.getColumnIndex("bairro")));
        v.setLogradouro(c.getString(c.getColumnIndex("logradouro")));
        v.setComplemento(c.getString(c.getColumnIndex("complemento")));
        v.setNumero(c.getString(c.getColumnIndex("numero")));
        v.setTelefone_fixo_pessoal(c.getString(c.getColumnIndex("telefone_fixo_pessoal")));
        v.setTelefone_celular_pessoal1(c.getString(c.getColumnIndex("telefone_celular_pessoal1")));
        v.setTelefone_celular_pessoal2(c.getString(c.getColumnIndex("telefone_celular_pessoal2")));
        v.setTelefone_celular_corporativo(c.getString(c.getColumnIndex("telefone_celular_corporativo")));
        v.setEmail_institucional(c.getString(c.getColumnIndex("email_institucional")));
        v.setEmail_pessoal(c.getString(c.getColumnIndex("email_pessoal")));
        v.setUpdate_username(c.getString(c.getColumnIndex("whoupdate")));
        v.setWhoupdate(c.getString(c.getColumnIndex("whoupdate")));
        v.setData_atualiz(c.getString(c.getColumnIndex("data_atualiz")));

        //dados profissionais
        v.setPis_pasep(c.getString(c.getColumnIndex("pis_pasep")));
        v.setCtps_numero(c.getString(c.getColumnIndex("ctps_numero")));
        v.setCtps_serie(c.getString(c.getColumnIndex("ctps_serie")));
        v.setCtps_uf(c.getString(c.getColumnIndex("ctps_uf")));


        //dados profissionais
        v.setNr_titulo(c.getString(c.getColumnIndex("nr_titulo")));
        v.setUf(c.getString(c.getColumnIndex("uf")));
        v.setZona(c.getString(c.getColumnIndex("zona")));
        v.setSecao(c.getString(c.getColumnIndex("secao")));

        //habilitação
        v.setNro_registro(c.getString(c.getColumnIndex("nro_registro")));
        v.setCategoria(c.getString(c.getColumnIndex("Categoria")));
        v.setData_validade(c.getString(c.getColumnIndex("data_validade")));

        //fisionomia
        v.setBarba(c.getString(c.getColumnIndex("barba")));
        v.setBigode(c.getString(c.getColumnIndex("bigode")));
        v.setCabCor(c.getString(c.getColumnIndex("cabCor")));
        v.setCabTipo(c.getString(c.getColumnIndex("cabTipo")));
        v.setCabTom(c.getString(c.getColumnIndex("cabTom")));
        v.setCutis(c.getString(c.getColumnIndex("cutis")));
        v.setOlhosCor(c.getString(c.getColumnIndex("olhosCor")));
        v.setOlhostom(c.getString(c.getColumnIndex("olhostom")));

        c.close();
        db.close();
        return v;
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
    public boolean update(DadosPessoaisVO vo , String cod) {

        SQLiteDatabase db     = new DBFichaMilitarHelper(ctx).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("cpf",vo.getCpf());
        values.put("rg",vo.getRg());
        values.put("matricula",vo.getMatricula());
        values.put("data_nasc",vo.getData_nasc());
        values.put("nome",vo.getNome());
        values.put("nome_pai",vo.getNome_pai());
        values.put("nome_mae",vo.getNome_mae());
        values.put("naturaldo",vo.getNaturaldo());
        values.put("cidadenatal",vo.getCidadenatal());
        values.put("alistmilitar",vo.getAlistmilitar());
        values.put("dsexo",vo.getDsexo());
        values.put("estado_civil",vo.getEstado_civil());
        values.put("religiao",vo.getReligiao());
        values.put("pis_pasep",vo.getPis_pasep());
        values.put("ctps_numero",vo.getCtps_numero());
        values.put("ctps_serie",vo.getCtps_serie());
        values.put("ctps_uf",vo.getCtps_uf());
        values.put("nr_titulo",vo.getNr_titulo());
        values.put("zona",vo.getZona());
        values.put("secao",vo.getSecao());
        values.put("uf",vo.getUf());
        values.put("barba",vo.getBarba());
        values.put("bigode",vo.getBigode());
        values.put("cabCor",vo.getCabCor());
        values.put("cabTipo",vo.getCabTipo());
        values.put("cabTom",vo.getCabTom());
        values.put("cutis",vo.getCutis());
        values.put("olhosCor",vo.getOlhostom());
        values.put("olhostom",vo.getOlhostom());
        values.put("Categoria",vo.getCategoria());
        values.put("nro_registro",vo.getNro_registro());
        values.put("data_validade",vo.getData_validade());
        values.put("cep",vo.getCep());
        values.put("bairro",vo.getBairro());
        values.put("numero",vo.getNumero());
        values.put("cidade",vo.getCidade());
        values.put("estado",vo.getEstado());
        values.put("logradouro",vo.getLogradouro());
        values.put("complemento",vo.getComplemento());
        values.put("telefone_fixo_pessoal",vo.getTelefone_fixo_pessoal());
        values.put("telefone_celular_pessoal1",vo.getTelefone_celular_pessoal1());
        values.put("telefone_celular_pessoal2",vo.getTelefone_celular_pessoal2());
        values.put("telefone_celular_pessoal3",vo.getTelefone_celular_pessoal3());
        values.put("telefone_celular_corporativo",vo.getTelefone_celular_corporativo());
        values.put("email_institucional",vo.getEmail_institucional());
        values.put("email_pessoal",vo.getEmail_pessoal());
        values.put("data_atualiz",vo.getData_atualiz());
        values.put("whoupdate",vo.getUpdate_username());
        if(db.update(table_name, values, "_id = ?", new String[]{cod}) > 0){
            db.close();
            return true;
        }else{
            return false;
        } }

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

    public boolean VerificaSeTemIdPessoaBD_Local(String idPessoa) {

        boolean tiporetorn = false;
        try {
            SQLiteDatabase db = new DBFichaMilitarHelper(ctx).getWritableDatabase();

            String[] busca = new String[]{idPessoa};

            Cursor c = db.query(table_name, colunas, "_id = ?", busca, null, null, null, null);
            if(c.getCount() > 0) {
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
