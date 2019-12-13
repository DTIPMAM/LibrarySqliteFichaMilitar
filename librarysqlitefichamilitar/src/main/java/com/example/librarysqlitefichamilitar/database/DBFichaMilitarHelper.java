package com.example.librarysqlitefichamilitar.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBFichaMilitarHelper extends SQLiteOpenHelper {
    private static int Version = 1;
    public DBFichaMilitarHelper(Context context) {
        super(context, "DBFichaMilitar", null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //FICHA MILITAR
        //inicio version 1
        db.execSQL("CREATE TABLE pessoas_dados_pessoais( _id INTEGER PRIMARY KEY, cpf VARCHAR(15), rg VARCHAR(10), matricula VARCHAR(10)," +
                "data_nasc  VARCHAR(10), nome VARCHAR(30), nome_pai VARCHAR(30), nome_mae VARCHAR(30),naturaldo VARCHAR(20),cidadenatal VARCHAR(20)," +
                "alistmilitar VARCHAR(10),dsexo VARCHAR(10),estado_civil VARCHAR(10),religiao VARCHAR(30),pis_pasep VARCHAR(10),ctps_numero VARCHAR(10)," +
                "ctps_serie VARCHAR(15),ctps_uf VARCHAR(15),nr_titulo VARCHAR(15),zona VARCHAR(10),secao VARCHAR(10),uf VARCHAR(20),barba VARCHAR(20)," +
                "bigode VARCHAR(20),cabCor VARCHAR(20),cabTipo VARCHAR(20),cabTom VARCHAR(20),cutis VARCHAR(20),olhosCor VARCHAR(20),olhostom VARCHAR(20)," +
                "Categoria VARCHAR(20),nro_registro VARCHAR(20),data_validade  VARCHAR(10)," +
                "cep VARCHAR(20),bairro VARCHAR(30),numero VARCHAR(5),cidade VARCHAR(30),estado VARCHAR(30),logradouro VARCHAR(50),complemento VARCHAR(30)," +
                "telefone_fixo_pessoal VARCHAR(12),telefone_celular_pessoal1 VARCHAR(12),telefone_celular_pessoal2 VARCHAR(12),telefone_celular_pessoal3 VARCHAR(12)," +
                "telefone_celular_corporativo VARCHAR(12),email_institucional VARCHAR(30),email_pessoal VARCHAR(30)," +
                "data_atualiz VARCHAR(20),whoupdate VARCHAR(30));");


        db.execSQL("CREATE TABLE pessoas_dados_profissionais( _id INTEGER PRIMARY KEY AUTOINCREMENT, id_pessoa INT,ctps_numero VARCHAR(10),ctps_serie VARCHAR(10),ctps_uf VARCHAR(10),pis_pasep VARCHAR(10));");
        db.execSQL("CREATE TABLE pessoas_formacao_academica( _id INTEGER PRIMARY KEY, id_pessoa INT, area VARCHAR(20), nome_curso VARCHAR(20), instituicao VARCHAR(30), finl VARCHAR(10), carga_horaria VARCHAR(10)," +
                " completo VARCHAR(5));");
        db.execSQL("CREATE TABLE pessoas_grau_instrucao( _id INTEGER PRIMARY KEY AUTOINCREMENT, id_pessoa INT, grauInstrucao VARCHAR(30));"); //auxiliar formacao academica

        db.execSQL("CREATE TABLE pessoas_cursos_militares( _id INTEGER PRIMARY KEY, id_pessoa INT, tipoCursoMilitar VARCHAR(30), nome_curso VARCHAR(30),instituicaoEnsino VARCHAR(30),inicio VARCHAR(10),finl VARCHAR(10),carga_horaria VARCHAR(10));");

        db.execSQL("CREATE TABLE pessoas_elogios( _id INTEGER PRIMARY KEY, id_pessoa INT, data_elogio VARCHAR(10), " +
                "descricao_elogio VARCHAR(30), nome_autoridade VARCHAR(30)," +
                "data_boletim VARCHAR(10),numero_boletim VARCHAR(5));");

        db.execSQL("CREATE TABLE pessoas_medalhas_condecoracoes( _id INTEGER PRIMARY KEY, id_pessoa INT, medalhaCondecoracao VARCHAR(30), " +
                "data_condecoracao DATE, data_boletim DATE," +
                "numero_boletim VARCHAR(5));");

        db.execSQL("CREATE TABLE pessoas_promocoes( _id INTEGER PRIMARY KEY, id_pessoa INT, TipoPromocao VARCHAR(30), descricao_promocao VARCHAR(30)," +
                "data_boletim DATE," +
                "numero_boletim VARCHAR(5));");

        db.execSQL("CREATE TABLE pessoas_conta_bancaria( _id INTEGER PRIMARY KEY, id_pessoa INT, banco VARCHAR(30), nragencia VARCHAR(10), " +
                "dvagencia VARCHAR(5), nrconta VARCHAR(15), dvconta VARCHAR(5), TipoConta VARCHAR(20));");

        db.execSQL("CREATE TABLE pessoas_puncoes( _id INTEGER PRIMARY KEY, id_pessoa INT, data_punicao DATE, descricao_punicao VARCHAR(30)," +
                "data_boletim DATE," +
                "numero_boletim VARCHAR(5));");

        db.execSQL("CREATE TABLE pessoas_dependentes( _id INTEGER PRIMARY KEY, id_pessoa INT, nome_dependente VARCHAR(30), cpf VARCHAR(15)," +
                "ci VARCHAR(10), parentesco VARCHAR(20), data_nascimento DATE, tipo_boletim VARCHAR(5), data_boletim DATE, numero_boletim VARCHAR(5));");

        db.execSQL("CREATE TABLE pessoas_dispensas_medicas( _id INTEGER PRIMARY KEY, id_pessoa INT, data_inicio DATE, data_termino DATE, " +
                "data_boletim DATE,numero_boletim VARCHAR(5), tipo_boletim VARCHAR(5), cid VARCHAR(5));");

        db.execSQL("CREATE TABLE pessoas_dados_militares( _id INTEGER PRIMARY KEY, cpf VARCHAR(15)," +
                "idt_militar VARCHAR(10),nome_guerra VARCHAR(20),antiguidade VARCHAR(10)," +
                "data_exp_identidade VARCHAR(10),Funcao VARCHAR(20),PostoPatente VARCHAR(15)," +
                "PostoQuadro VARCHAR(30),FuncaoGratificada VARCHAR(10),comportamento VARCHAR(10)," +
                "data_inclusao VARCHAR(10),bg_inclusao VARCHAR(5),bg_inclusao_data VARCHAR(10)," +
                "data_exclusao VARCHAR(10),bg_exclusao VARCHAR(5),bg_exclusao_data VARCHAR(10)," +
                "tamanho_calca VARCHAR(5),tamanho_camisa VARCHAR(5),tamanho_sapato VARCHAR(5)," +
                "tamanho_gorro VARCHAR(5),tamanho_gandola VARCHAR(5),tamanho_calca_instrucao VARCHAR(5)," +
                "tamanho_canicola VARCHAR(5),tamanho_calcao_tfm VARCHAR(5),tamanho_coturno VARCHAR(5)," +
                "tamanho_saia VARCHAR(5),lotacao VARCHAR(20),status VARCHAR(20),situacao VARCHAR(20),data_atualiz VARCHAR(20), whoupdate VARCHAR(20));");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {

           /* if (newV == Version && oldV == Version - 1) {



            }*/


    }

    //usado para verificar se uma coluna existe em uma tabela, pois a mesma pode ter sido colocada em versões antigas e removidas
    private boolean isFieldExist(SQLiteDatabase db, String tableName, String fieldName) {
        boolean isExist = false;

        Cursor res = null;

        try {

            res = db.rawQuery("Select * from " + tableName + " limit 1", null);

            int colIndex = res.getColumnIndex(fieldName);
            if (colIndex != -1) {
                isExist = true;
            }

        } catch (Exception e) {
        } finally {
            try {
                if (res != null) {
                    res.close();
                }
            } catch (Exception e1) {
            }
        }

        return isExist;
    }

}