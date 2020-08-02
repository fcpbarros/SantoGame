package com.santodia.divinaacao;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

/**
 * Testing first commit
 */

public class MainActivity extends AppCompatActivity {

    private static final long TEMPO_INICIO_MILISSEGUNDOS = 60000;

    private CountDownTimer mCountDownTimer;

    private TextView timer,catPernambuco,cat_pernambucoPont,catPernambuco2,cat_pernambuco2Pont,catAcao,cat_acaoPont,catAcao2,cat_acao2Pont,catObjeto,cat_objetoPont,catObjeto2,cat_objeto2Pont,catDificil,cat_dificilPont,catDificil2,cat_dificil2Pont,catPessoa,cat_pessoaPont,catPessoa2,cat_pessoa2Pont;
    private Button botaoIniciar;
    private Button botaoReset;
    private LinearLayout botaoGerador;

    private boolean TimerRunning;

    private long TempoRestante = TEMPO_INICIO_MILISSEGUNDOS;

    private static final int TAMANHO_DAS_CATEGORIAS = 71;
    private int p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
    ArrayList<String> pernambuco = new ArrayList<>();
    ArrayList<String> acao = new ArrayList<>();
    ArrayList<String> dificil = new ArrayList<>();
    ArrayList<String> pessoa = new ArrayList<>();
    ArrayList<String> objeto = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carregarCategorias();

        botaoGerador = findViewById(R.id.botaoGerador);
        timer = findViewById(R.id.timerView);
        botaoIniciar = findViewById(R.id.botaoInicio);
        botaoReset = findViewById(R.id.botaoResetar);
        catPernambuco = findViewById(R.id.cat_pernambuco);
        cat_pernambucoPont = findViewById(R.id.cat_pernambucoPont);
        catPernambuco2 = findViewById(R.id.cat_pernambuco2);
        cat_pernambuco2Pont = findViewById(R.id.cat_pernambuco2Pont);
        catAcao = findViewById(R.id.cat_acao);
        cat_acaoPont = findViewById(R.id.cat_acaoPont);
        catAcao2 = findViewById(R.id.cat_acao2);
        cat_acao2Pont = findViewById(R.id.cat_acao2Pont);
        catPessoa = findViewById(R.id.cat_pessoa);
        cat_pessoaPont = findViewById(R.id.cat_pessoaPont);
        catPessoa2 = findViewById(R.id.cat_pessoa2);
        cat_pessoa2Pont = findViewById(R.id.cat_pessoa2Pont);
        catDificil = findViewById(R.id.cat_dificil);
        cat_dificilPont = findViewById(R.id.cat_dificilPont);
        catDificil2 = findViewById(R.id.cat_dificil2);
        cat_dificil2Pont = findViewById(R.id.cat_dificil2Pont);
        catObjeto = findViewById(R.id.cat_objeto);
        cat_objetoPont = findViewById(R.id.cat_objetoPont);
        catObjeto2 = findViewById(R.id.cat_objeto2);
        cat_objeto2Pont = findViewById(R.id.cat_objeto2Pont);

        botaoGerador.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                p1 = new Random().nextInt(TAMANHO_DAS_CATEGORIAS);
                p2 = new Random().nextInt(TAMANHO_DAS_CATEGORIAS);
                while (p1 == p2) {
                    p2 = new Random().nextInt(TAMANHO_DAS_CATEGORIAS);
                }
                p3 = new Random().nextInt(TAMANHO_DAS_CATEGORIAS);
                p4 = new Random().nextInt(TAMANHO_DAS_CATEGORIAS);
                while(p3 == p4){
                    p4 = new Random().nextInt(TAMANHO_DAS_CATEGORIAS);
                }
                p5 = new Random().nextInt(TAMANHO_DAS_CATEGORIAS);
                p6 = new Random().nextInt(TAMANHO_DAS_CATEGORIAS);
                while(p5 == p6){
                    p6 = new Random().nextInt(TAMANHO_DAS_CATEGORIAS);
                }
                p7 = new Random().nextInt(TAMANHO_DAS_CATEGORIAS);
                p8 = new Random().nextInt(TAMANHO_DAS_CATEGORIAS);
                while(p7 == p8){
                    p8 = new Random().nextInt(TAMANHO_DAS_CATEGORIAS);
                }
                p9 = new Random().nextInt(TAMANHO_DAS_CATEGORIAS);
                p10 = new Random().nextInt(TAMANHO_DAS_CATEGORIAS);
                while(p9 == p10){
                    p10 = new Random().nextInt(TAMANHO_DAS_CATEGORIAS);
                }
                mostrarPalavras(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10);

            }
        });

        botaoIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        botaoReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        atualizarContagem();

    }

    private void carregarCategorias(){

        //categoria pernambuco
        pernambuco.add("Divina Flor;3");
        pernambuco.add("Estandarte;1");
        pernambuco.add("Atelier Guada;3");
        pernambuco.add("Casa de Chá;1");
        pernambuco.add("Bolo de noiva;2");
        pernambuco.add("Casa Bebidas;1");
        pernambuco.add("Vale dos Eucaliptos;3");
        pernambuco.add("Sítio do Sapoti;3");
        pernambuco.add("Usina Dois Irmãos;2");
        pernambuco.add("Vila Alecrim;3"); //ok
        pernambuco.add("Pousada do Amparo;3");
        pernambuco.add("Espaço Meu Caminho;4");
        pernambuco.add("Sítio Horizonte Azul;3");
        pernambuco.add("Garrido Galeria;4");
        pernambuco.add("Reserva da Coruja;2");
        pernambuco.add("Recanto das Sucupiras;2");
        pernambuco.add("O Pátio;4");
        pernambuco.add("Hotel Campestre de Aldeia;5");
        pernambuco.add("Todas as Luas;2"); //ok
        pernambuco.add("Senta Festa;2");
        pernambuco.add("A Luz do Dia;2");
        pernambuco.add("Catamaran Eventos;4");
        pernambuco.add("Capela da Praia;3");
        pernambuco.add("Di Branco;2");
        pernambuco.add("Benta Brigadeira;2");
        pernambuco.add("Lupa Doces;1");
        pernambuco.add("Arquitetando Doces;3");
        pernambuco.add("Fada Açucarada;1");
        pernambuco.add("Doce Bolinha;2"); //ok
        pernambuco.add("Villa Sandino;4");
        pernambuco.add("Algo Doce;4");
        pernambuco.add("Verde Menta;3");
        pernambuco.add("Paraíso Decor;2"); //ok
        pernambuco.add("Lembre-lembre;3");
        pernambuco.add("Bora Bora;2");
        pernambuco.add("Lírio de Papel;4");
        pernambuco.add("Bora Bora;2");
        pernambuco.add("Ingá Vinhos;4");
        pernambuco.add("Laços Oficina de Sonhos;2");
        pernambuco.add("Dona Xique Xique;4");
        pernambuco.add("Sonho Meu;2");
        pernambuco.add("Conto de Fadas;1");
        pernambuco.add("Garimpe e Decore;4");
        pernambuco.add("Romeu e Julieta Filmes;2"); //ok
        pernambuco.add("Nuvem de Arroz;2");
        pernambuco.add("Caju Artigos;3");
        pernambuco.add("Mila Moura;6");
        pernambuco.add("Sniff Brigadeiros;6");
        pernambuco.add("Orquestra Novo Tempo;2");
        pernambuco.add("Orquestra Fascinação;3");
        pernambuco.add("Geramais Geradores;4");
        pernambuco.add("Amiúde Papelaria;5");
        pernambuco.add("Oba Criativa;3");
        pernambuco.add("Adorno Locação;4");
        pernambuco.add("Celeiro Eventos;1"); //ok
        pernambuco.add("Donna da Casa;2");
        pernambuco.add("Mercearia de Ideias;4");
        pernambuco.add("Orgânica;3");
        pernambuco.add("Bolo de rolo;2");
        pernambuco.add("Água de coco;1");
        pernambuco.add("Frevo;1");
        pernambuco.add("Espaço Califórnia;4");
        pernambuco.add("Pousada dos Quatro Cantos;2");
        pernambuco.add("Píer 31;3");
        pernambuco.add("Hotel 7 Colinas;1");
        pernambuco.add("Convento de São Francisco;3"); //ok
        pernambuco.add("Rua das Calçadas;5");
        pernambuco.add("Bolsa de Madame;4");
        pernambuco.add("Igreja Nossa Senhora do Amparo;2");
        pernambuco.add("Igreja Madre de Deus;3");
        pernambuco.add("Congelar o bolo;5");

        //fim da categoria pernambuco

        //categoria ação

        acao.add("Jurar;3"); //ok
        acao.add("Polir;4"); //ok
        acao.add("Parcelar;3"); //ok
        acao.add("Contratar;2"); //ok
        acao.add("Assinar;1"); //ok
        acao.add("Orçar;3"); //ok
        acao.add("Degustar;1"); //ok
        acao.add("Brindar;1"); //ok
        acao.add("Dançar;1"); //ok
        acao.add("Suar;1"); //ok
        acao.add("Chorar;2"); //ok
        acao.add("Abençoar;2"); //ok
        acao.add("Aceitar;1"); //ok
        acao.add("SIM!;2"); //ok
        acao.add("Mazel Tov!;6"); //ok
        acao.add("Aplaudir;1"); //ok
        acao.add("Cantar;2"); //ok
        acao.add("Provar;3"); //ok
        acao.add("Escrever os votos;4"); //ok
        acao.add("Passar o som;5"); //ok
        acao.add("Colocar a mão na massa;3"); //ok
        acao.add("Marcar;3");  //ok adicionar
        acao.add("Noivar;3"); //ok
        acao.add("Agradecer;2"); //ok
        acao.add("Conduzir;5"); //ok
        acao.add("Escolher;1"); //ok
        acao.add("Suspirar;2"); //ok
        acao.add("Manobrar;3"); //ok
        acao.add("Jogar confete;3"); //ok
        acao.add("Beber;2"); //ok
        acao.add("Reduzir;4"); //ok
        acao.add("Reciclar;4"); //ok
        acao.add("Reutilizar;4"); //ok
        acao.add("Planejar;3"); //ok
        acao.add("Pagar;1"); //ok
        acao.add("Negociar;2"); //ok
        acao.add("Ponderar;2"); //ok
        acao.add("Beijar;1"); //ok
        acao.add("Abraçar forte;2"); //ok
        acao.add("Sorrir;1"); //ok
        acao.add("Vibrar;2"); //ok
        acao.add("Ofegar;2"); //ok
        acao.add("Organizar;3"); //ok
        acao.add("Suar frio;4"); //ok
        acao.add("Desejar;2"); //ok
        acao.add("Sonhar acordado;2"); //ok
        acao.add("Reservar;4"); //ok
        acao.add("Prometer;4"); //ok
        acao.add("Acreditar;2"); //ok
        acao.add("Compartilhar;1"); //ok
        acao.add("Pesquisar;2"); //ok
        acao.add("Avaliar;3"); //ok
        acao.add("Solicitar;3"); //ok
        acao.add("Colaborar;2"); //ok
        acao.add("Ajustar;2"); //ok
        acao.add("Pular de alegria;1"); //ok
        acao.add("Aprovar;1"); //ok
        acao.add("Torcer;1"); //ok
        acao.add("Testemunhar;2"); //ok
        acao.add("Dar as mãos;2"); //ok adicionado
        acao.add("Selar;2");
        acao.add("Trocar alianças;3");
        acao.add("Aguardar;2");
        acao.add("Acompanhar;3");
        acao.add("Respeitar;4");
        acao.add("Celebrar;3");
        acao.add("Parabenizar;2");
        acao.add("Registrar;3");
        acao.add("Juntar as escovas de dentes;4");
        acao.add("Partir o bolo;2");
        acao.add("Viajar;3");


        //fim da categoria ação

        // categoria dificil

        dificil.add("Cronograma;3");
        dificil.add("Iluminador;2");
        dificil.add("Álbum de fotos;2");
        dificil.add("Ourive;3");
        dificil.add("Aparador;4");
        dificil.add("Plano de fotos;3");
        dificil.add("Gola;2");
        dificil.add("Partitura;2");
        dificil.add("Abotoadura;2");
        dificil.add("Gin tônica;3");
        dificil.add("Laço;1");
        dificil.add("Na saúde e na doença;3");
        dificil.add("Cartório;2");
        dificil.add("Protetor de salto;1");
        dificil.add("Porta aliança;2");
        dificil.add("ECAD;3");
        dificil.add("Boleto bancário;2");
        dificil.add("Degustação de espumante;2");
        dificil.add("Proposta;3");
        dificil.add("E-mail;2");
        dificil.add("Reunião virtual;1");
        dificil.add("Casamento celta;3");
        dificil.add("Relicário;4");
        dificil.add("Ritual;2");
        dificil.add("Ensaio;1");
        dificil.add("Perlage;6");
        dificil.add("Cerimônia das areias;3");
        dificil.add("Dia Branco;3");
        dificil.add("Marcha nupcial;1");
        dificil.add("Aquarela;2");
        dificil.add("Tons pastel;3");
        dificil.add("Lacre de cera;2");
        dificil.add("Chuppah;6");
        dificil.add("Quipá;6");
        dificil.add("Oferenda;2"); //metade
        dificil.add("Sete voltas;4");
        dificil.add("Dedo anelar;2");
        dificil.add("Vela;1");
        dificil.add("Lua de mel;2");
        dificil.add("Genuflexório;3");
        dificil.add("Borboletas no estômago;2");
        dificil.add("Forminha de acetato;3");
        dificil.add("Cartão de agradec.;2");
        dificil.add("Confirmação de presença;1");
        dificil.add("Coro;2");
        dificil.add("Fórum;1");
        dificil.add("Obi;6");
        dificil.add("Lágrimas de alegria;3");
        dificil.add("KVA;6");
        dificil.add("Fita floral;2");
        dificil.add("Sinete;3");
        dificil.add("Espuma floral;3");
        dificil.add("Santo Dia;6");
        dificil.add("Estúdio Tatu;6");
        dificil.add("Saída de emergência;2");
        dificil.add("Lista de presente;2");
        dificil.add("Templo religioso;3");
        dificil.add("Lanterna chinesa;2");
        dificil.add("Celebre Eventos;3");
        dificil.add("Tradição;2");
        dificil.add("Dar PT;1");
        dificil.add("Desmontagem;2");
        dificil.add("Estola;4");
        dificil.add("Santo Antônio;4");
        dificil.add("Fernanda Floret;5");
        dificil.add("Socorro;2");
        dificil.add("Constance Zahn;5");
        dificil.add("Lápis de Noiva;3");
        dificil.add("Pinterest;3");
        dificil.add("Capela;1");
        dificil.add("Palco;4");
        // fim da categoria dificil

        // categoria objeto

        objeto.add("Aliança;2");
        objeto.add("Véu;3");
        objeto.add("Grinalda;3");
        objeto.add("Salto alto;1");
        objeto.add("Rasteirinha;1");
        objeto.add("Chinelo;1");
        objeto.add("Caneca de chope;2");
        objeto.add("Taça de cristal;2");
        objeto.add("Espátula;3");
        objeto.add("Confete;2");
        objeto.add("Arroz;1");
        objeto.add("Buquê;1");
        objeto.add("Gravata borboleta;3");
        objeto.add("Sapato;3");
        objeto.add("Bandeja;2");
        objeto.add("Colete;1");
        objeto.add("Botão;1");
        objeto.add("Bem-casado;2");
        objeto.add("Bolo;1");
        objeto.add("Brigadeiro;1");
        objeto.add("Grampo de cabelo;3");
        objeto.add("Alfinete;3");
        objeto.add("Rolha;1");
        objeto.add("Microfone;2");
        objeto.add("Espumante;2");
        objeto.add("Livro de assinaturas;3");
        objeto.add("Seda;2");
        objeto.add("Envelope;3");
        objeto.add("Costume;3");
        objeto.add("Batom;2");
        objeto.add("Uísque;3");
        objeto.add("Prendedor de gravata;3");
        objeto.add("Mesa de som;4");
        objeto.add("Luz;2");
        objeto.add("Terço;1"); //metade
        objeto.add("Painel de LED;2");
        objeto.add("Foto instantânea;3");
        objeto.add("Arranjo de lapela;3");
        objeto.add("Cruxifixo;2");
        objeto.add("Rosa;2");
        objeto.add("Máquina de chope;2");
        objeto.add("Vodca;3");
        objeto.add("Tequila;1");
        objeto.add("Repelente;1");
        objeto.add("Cadeira;1");
        objeto.add("Ar condicionado;2");
        objeto.add("Climatizador;2");
        objeto.add("Terno;3");
        objeto.add("Mexedor;2");
        objeto.add("Canudo;2");
        objeto.add("Bolo;2");
        objeto.add("Guardanapo;2");
        objeto.add("Gerador;1");
        objeto.add("Cortina;2");
        objeto.add("Porta infinita;3");
        objeto.add("Prato principal;2");
        objeto.add("Gambiarra;3");
        objeto.add("Monograma;1");
        objeto.add("Lembrancinha;1");
        objeto.add("Suspensório;1");
        objeto.add("Pré convite;2");
        objeto.add("Menu;1");
        objeto.add("Toldo;2");
        objeto.add("Pétalas;2");
        objeto.add("Prancheta;3");
        objeto.add("Saco de organza;2");
        objeto.add("Altar;2");
        objeto.add("Brincos;1");
        objeto.add("Batina;4");
        objeto.add("Passadeira;3");
        objeto.add("Rádio comunicador;3");

        // fim da categoria objeto

        // categoria pessoa

        pessoa.add("Decoradora;3");
        pessoa.add("Decorador;3");
        pessoa.add("Florista;4");
        pessoa.add("Copeiro;5");
        pessoa.add("Copeira;6");
        pessoa.add("Cheff;3");
        pessoa.add("Garçonete;2");
        pessoa.add("Garçom;1");
        pessoa.add("Barman;3");
        pessoa.add("Operador de som;6");
        pessoa.add("Recepcionista;5");
        pessoa.add("Cerimonialista;4");
        pessoa.add("Celebrante;2");
        pessoa.add("Padre;1");
        pessoa.add("Juiz de paz;3");
        pessoa.add("Assessor de eventos;1");
        pessoa.add("Assessora de eventos;3");
        pessoa.add("Segurança;2");
        pessoa.add("Eletricista;3");
        pessoa.add("Operador de gerador;3");
        pessoa.add("Roda de samba;4");
        pessoa.add("Fotógrafo;2");
        pessoa.add("Fotógrafa;3");
        pessoa.add("Cinegrafista;3");
        pessoa.add("Assistente;4");
        pessoa.add("Maquiadora;3");
        pessoa.add("Estilista;3");
        pessoa.add("Costureira;3");
        pessoa.add("Alfaiate;4");
        pessoa.add("Confeiteira;2");
        pessoa.add("Caseiro;3");
        pessoa.add("Cantor;1");
        pessoa.add("Baixista;3");
        pessoa.add("Cantora;1");
        pessoa.add("Tecladista;3");
        pessoa.add("Daminha;2");
        pessoa.add("Pajem;2");
        pessoa.add("Noivo;1");
        pessoa.add("Noiva;1");
        pessoa.add("Sogra;1");
        pessoa.add("Madrinha;2");
        pessoa.add("Padrinho;1");
        pessoa.add("Testemunha;3");
        pessoa.add("Manobrista;2");
        pessoa.add("Designer;4");
        pessoa.add("Calígrafo;4");
        pessoa.add("Calígrafa;5");
        pessoa.add("Recreador;4");
        pessoa.add("Recreadora;4");
        pessoa.add("Motorista;6");
        pessoa.add("Orquestra de frevo;5");
        pessoa.add("Maestro;5");
        pessoa.add("Maestrina;6");
        pessoa.add("Violinista;3");
        pessoa.add("Fornecedor;4");
        pessoa.add("Quarteto de cordas;5");
        pessoa.add("Contratante;5");
        pessoa.add("DJ;5");
        pessoa.add("VJ;6");
        pessoa.add("Blogueira;3");
        pessoa.add("Blogueiro;2");
        pessoa.add("Gerente comercial;4");
        pessoa.add("Ilustrador;2");
        pessoa.add("Pastor;3");
        pessoa.add("Jardineiro;5");
        pessoa.add("Auxiliar de cozinha;4");
        pessoa.add("Auxiliar de serviços gerais;6");
        pessoa.add("Editor;4");
        pessoa.add("Baterista;2");
        pessoa.add("Rabino;6");
        pessoa.add("Guitarrista;4");

        // fim da categoria pessoa

    }

    private void mostrarPalavras(int p1, int p2,int p3,int p4,int p5,int p6,int p7,int p8,int p9,int p10){
        String v1 = pernambuco.get(p1);
        String[] pernambuco1Div = v1.split(";");
        catPernambuco.setText(pernambuco1Div[0]);
        cat_pernambucoPont.setText(pernambuco1Div[1]);
        String v2 = pernambuco.get(p2);
        String[] pernambuco2Div = v2.split(";");
        catPernambuco2.setText(pernambuco2Div[0]);
        cat_pernambuco2Pont.setText(pernambuco2Div[1]);
        String v3 = acao.get(p3);
        String[] acao1Div = v3.split(";");
        catAcao.setText(acao1Div[0]);
        cat_acaoPont.setText(acao1Div[1]);
        String v4 = acao.get(p4);
        String[] acao2Div = v4.split(";");
        catAcao2.setText(acao2Div[0]);
        cat_acao2Pont.setText(acao2Div[1]);
        String v5 = dificil.get(p5);
        String[] dificil1Div = v5.split(";");
        catDificil.setText(dificil1Div[0]);
        cat_dificilPont.setText(dificil1Div[1]);
        String v6 = dificil.get(p6);
        String[] dificil2Div = v6.split(";");
        catDificil2.setText(dificil2Div[0]);
        cat_dificil2Pont.setText(dificil2Div[1]);
        String v7 = pessoa.get(p7);
        String[] pessoaDiv = v7.split(";");
        catPessoa.setText(pessoaDiv[0]);
        cat_pessoaPont.setText(pessoaDiv[1]);
        String v8 = pessoa.get(p8);
        String[] pessoa2Div = v8.split(";");
        catPessoa2.setText(pessoa2Div[0]);
        cat_pessoa2Pont.setText(pessoa2Div[1]);
        String v9 = objeto.get(p9);
        String[] objeto1div = v9.split(";");
        catObjeto.setText(objeto1div[0]);
        cat_objetoPont.setText(objeto1div[1]);
        String v10 = objeto.get(p10);
        String[] objeto2div = v10.split(";");
        catObjeto2.setText(objeto2div[0]);
        cat_objeto2Pont.setText(objeto2div[1]);

    }


    private void startTimer() {
        mCountDownTimer = new CountDownTimer(TempoRestante, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                TempoRestante = millisUntilFinished;
                TimerRunning = true;
                atualizarContagem();
            }

            @Override
            public void onFinish() {
                TimerRunning = false;
                botaoIniciar.setText("iniciar");
                botaoIniciar.setVisibility(View.INVISIBLE);
                botaoReset.setVisibility(View.VISIBLE);
            }
        }.start();


        botaoIniciar.setText("pausar");
        botaoReset.setVisibility(View.INVISIBLE);
        botaoGerador.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        TimerRunning = false;
        botaoIniciar.setText("iniciar");
        botaoReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        TempoRestante = TEMPO_INICIO_MILISSEGUNDOS;
        atualizarContagem();
        //botaoReset.setVisibility(View.INVISIBLE);
        botaoIniciar.setVisibility(View.VISIBLE);
        botaoGerador.setVisibility(View.VISIBLE);
        catPernambuco.setText("");
        cat_pernambucoPont.setText("");
        catPernambuco2.setText("");
        cat_pernambuco2Pont.setText("");
        catObjeto.setText("");
        cat_objetoPont.setText("");
        catObjeto2.setText("");
        cat_objeto2Pont.setText("");
        catPessoa.setText("");
        cat_pessoaPont.setText("");
        catPessoa2.setText("");
        cat_pessoa2Pont.setText("");
        catAcao.setText("");
        cat_acaoPont.setText("");
        catAcao2.setText("");
        cat_acao2Pont.setText("");
        catDificil.setText("");
        cat_dificilPont.setText("");
        catDificil2.setText("");
        cat_dificil2Pont.setText("");
    }

    private void atualizarContagem() {
        int minutes = (int) (TempoRestante / 1000) / 60;
        int seconds = (int) (TempoRestante / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        try {
            timer.setText(timeLeftFormatted);
        } catch (NullPointerException e) {
            String b = "errouuuuu";
        }
        //timer.setText(timeLeftFormatted);
    }


}
