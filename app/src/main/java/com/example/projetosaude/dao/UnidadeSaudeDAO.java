package com.example.projetosaude.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import com.example.projetosaude.modelo.UnidadeSaude;

/**
 * Created by alura on 12/08/15.
 */
public class UnidadeSaudeDAO extends SQLiteOpenHelper {
    public UnidadeSaudeDAO(Context context) {
        super(context, "Agenda", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Alunos (id INTEGER PRIMARY KEY, " +
                "nome TEXT NOT NULL, " +
                "endereco TEXT, " +
                "telefone TEXT, " +
                "site TEXT, " +
                "nota REAL, " +
                "caminhoFoto TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "";
        switch (oldVersion) {
            case 1:
                sql = "ALTER TABLE Alunos ADD COLUMN caminhoFoto TEXT";
                db.execSQL(sql); // indo para versao 2
        }

    }

    public void insere(UnidadeSaude unidadeSaude) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosDoAluno(unidadeSaude);

        db.insert("Alunos", null, dados);
    }

    @NonNull
    private ContentValues pegaDadosDoAluno(UnidadeSaude unidadeSaude) {
        ContentValues dados = new ContentValues();
        dados.put("nome", unidadeSaude.getNome());
        dados.put("endereco", unidadeSaude.getEndereco());
        dados.put("telefone", unidadeSaude.getTelefone());
        dados.put("site", unidadeSaude.getSite());
        dados.put("nota", unidadeSaude.getNota());
        dados.put("caminhoFoto", unidadeSaude.getCaminhoFoto());
        return dados;
    }

    public List<UnidadeSaude> buscaAlunos() {
        String sql = "SELECT * FROM Alunos;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<UnidadeSaude> unidadeSaudes = new ArrayList<UnidadeSaude>();
        while (c.moveToNext()) {
            UnidadeSaude unidadeSaude = new UnidadeSaude();
            unidadeSaude.setId(c.getLong(c.getColumnIndex("id")));
            unidadeSaude.setNome(c.getString(c.getColumnIndex("nome")));
            unidadeSaude.setEndereco(c.getString(c.getColumnIndex("endereco")));
            unidadeSaude.setTelefone(c.getString(c.getColumnIndex("telefone")));
            unidadeSaude.setSite(c.getString(c.getColumnIndex("site")));
            unidadeSaude.setNota(c.getDouble(c.getColumnIndex("nota")));
            unidadeSaude.setCaminhoFoto(c.getString(c.getColumnIndex("caminhoFoto")));

            unidadeSaudes.add(unidadeSaude);
        }
        c.close();

        return unidadeSaudes;
    }

    public void deleta(UnidadeSaude unidadeSaude) {
        SQLiteDatabase db = getWritableDatabase();

        String[] params = {unidadeSaude.getId().toString()};
        db.delete("Alunos", "id = ?", params);
    }

    public void altera(UnidadeSaude unidadeSaude) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosDoAluno(unidadeSaude);

        String[] params = {unidadeSaude.getId().toString()};
        db.update("Alunos", dados, "id = ?", params);
    }

    public boolean ehAluno(String telefone) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Alunos WHERE telefone = ?", new String[]{telefone});
        int resultados = c.getCount();
        c.close();
        return resultados > 0;
    }
}
