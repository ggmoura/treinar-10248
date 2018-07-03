package br.com.treinar.bb.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import br.com.treinar.bb.model.banco.Banco;
import br.com.treinar.bb.model.banco.Conta;
import br.com.treinar.bb.model.banco.ContaCorrente;
import br.com.treinar.bb.model.banco.ContaPoupanca;
import br.com.treinar.bb.model.banco.ContaSalario;
import br.com.treinar.bb.model.banco.TipoConta;

public class BBUtil {

	private static BBUtil instance;
	private Properties prop;
	private Banco banco;
	private Gson gson;

	static {
		instance = new BBUtil();
	}

	private BBUtil() {
		super();
		loadProperties();
		loadData();
		buildGson();
	}

	private void buildGson() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		gsonBuilder.registerTypeAdapter(Conta.class, new ContaDeserializer());
		this.gson = gsonBuilder.create();
	}

	private void loadData() {
		StringBuilder bancoText = new StringBuilder();
		try {
			InputStream is = new FileInputStream("banco.json");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String linha = br.readLine(); // primeira linha
			while (linha != null) {
				bancoText.append(linha);
				linha = br.readLine();
			}
			is.close();
			banco = gson.fromJson(bancoText.toString(), Banco.class);
			if (banco.getContas() == null) {
				banco.setContas(new ArrayList<>());
			}
			System.out.println("dados carregados");
		} catch (Exception e) {
			banco = new Banco();
			banco.setContas(new ArrayList<>());
		}
	}

	public void persistirDados() {
		try {
			OutputStream os = new FileOutputStream("banco.json", Boolean.FALSE);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(gson.toJson(banco));
			bw.close();
		} catch (Exception e) {
			System.out.println("Erro ao persistir os dados");
		}
	}

	private void loadProperties() {
		try (InputStream in = new FileInputStream("config.properties")) {
			prop = new Properties();
			prop.load(in);
		} catch (IOException e) {
			System.out.println("Erro ao recuperar as propriedades");
			System.exit(0);
		}
	}

	public static BBUtil getInstance() {
		return instance;
	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}

	public Banco getBanco() {
		return banco;
	}

	private class ContaDeserializer implements JsonDeserializer<Conta> {

		@Override
		public Conta deserialize(JsonElement json, Type arg1, JsonDeserializationContext context)
				throws JsonParseException {
			JsonObject jsonObject = json.getAsJsonObject();
			JsonElement type = jsonObject.get("type");
			if (type != null) {
				switch (TipoConta.valueOf(type.getAsString())) {
				case CORRENTE:
					return context.deserialize(jsonObject, ContaCorrente.class);
				case POUPANCA:
					return context.deserialize(jsonObject, ContaPoupanca.class);
				case SALARIO:
					return context.deserialize(jsonObject, ContaSalario.class);
				}
			}
			return null;
		}
		
		
	}

}

