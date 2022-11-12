package controle;

import java.util.ArrayList;
import java.util.Scanner;
import dados.Cliente;
import dados.Conta;

public class OperaBanco {

    ArrayList<Cliente> clientList = new ArrayList<>();
    ArrayList<Conta> contaList = new ArrayList<>();

    
    private boolean add;


    //CADASTRO CLIENTE:

    public void cadastrarCliente(){
        Scanner scan = new Scanner(System.in);
        Scanner scanint = new Scanner(System.in);
        Cliente cliente = new Cliente();
        System.out.print("\n\nCADASTRO CLIENTE:");
        System.out.print("\n\nDigite o CPF do cliente: ");
        String checkCpf = scan.nextLine();
        boolean achado = false;

        for (Cliente client : clientList) {
            if (checkCpf.contentEquals(client.cpf)){
                achado = true;
                System.out.print("O cliente ja esta cadastrado!\n\n[1]Tentar novamente.   [2]Voltar para o menu.   [3]Sair.\nEscolha uma opção: ");
                int select = scanint.nextInt();

                switch(select){
                    case 1:{
                    cadastrarCliente();
                    break;
                    }
                    case 2:{
                    menuSelect();
                    break;
                    }
                    case 3:{
                    System.out.print("PROGRAMA FINALIZADO COM SUCESSO!");
                    }
                }
            }
        }//FINAL FOR CASO NÃO ACHE

        if(achado == false){
            
            cliente.cpf = checkCpf;

            System.out.print("Digite o nome do cliente: ");
                cliente.nome = scan.nextLine();
        
            System.out.print("Digite a profissão do cliente: ");
                cliente.profissao = scan.nextLine();
                
            add = clientList.add(cliente);

            System.out.print("\nCLIENTE CADASTRADO COM SUCESSO!\n\n[1]Cadastrar um novo cliente.\n[2]Voltar para o menu.\n[3]Sair.\nEscolha uma das opções:");

            int select = scanint.nextInt();
                switch(select){
                    case 1:{
                        cadastrarCliente();
                    break;
                    }
                    case 2:{
                        menuSelect();
                    }
                    case 3:{
                        System.out.print("\n\nPROGRAMA FINALIZADO COM SUCESSO!");
                    }
                   
                }
        }
        menuSelect();
    }

//-------------------------------------------------------------------------------------------------------------

    public void cadastroConta(){

        Scanner scan = new Scanner(System.in);
        Scanner scanint = new Scanner(System.in);
        Cliente cliente = new Cliente();
        
        System.out.print("\n\nCADASTRO CONTA:\n\nDigite o CPF do cliente que deseja cadastrar a conta: ");
        String checkCpf = scan.nextLine();
        boolean achado = false;

        for (Cliente client : clientList) {
            if (checkCpf.contentEquals(client.cpf)){
                if(client.conta.agencia == 0){
                    achado = true;

                    System.out.print("Cadastre um numero de agencia para o cliente "+client.nome+" : ");
                        client.conta.agencia = scan.nextInt();
                        cliente.conta.agencia = client.conta.agencia;
                    System.out.print("Insira um valor inicial para a conta do cliente: ");
                        client.conta.saldo = scan.nextDouble();
                        cliente.conta.saldo = client.conta.saldo;
                    add = contaList.add(cliente.conta);

                    System.out.print("\nCONTA CADASTRADA COM SUCESSO!\n\n[1]Voltar para o menu.   [2]Sair.\nEscolha uma das opções: ");
                    int select = scanint.nextInt();

                    switch(select){

                        case 1:{
                        break;
                    
                        }
                        case 2:{
                        System.out.print("\n\nPROGRAMA FINALIZADO COM SUCESSO!");
                        }
                    }
                }
                menuSelect();
            }
        }
        //FINAL CADASTRO CLEINTE
        if (achado == false){
            System.out.print("\nCPF não encontrado. O cliente não possui cadastro ou ja póssui uma conta.\n[1]Tentar novamente.   [2]Cadastrar cliente.  [3]Voltar para o menu   [3]Sair.\nEscolha a opção desejada:");
                int select = scanint.nextInt();

                switch(select){
                    case 1:{
                    cadastroConta();
                    break;
                    }
                    case 2:{
                    cadastrarCliente();
                    break;
                    }
                    case 3 :{
                    break;
                    }
                    case 4:{
                    System.out.print("\n\nPROGRAMA FINALIZADO COM SUCESSO!");
                    
                    }
                }
        }
    }

    public void depositoCliente(){

        Scanner scan = new Scanner(System.in);
        Scanner scanint = new Scanner(System.in);
        


        System.out.print("\n\nCADASTRO CONTA:\n\nDigite o CPF do cliente que fazer o deposito: ");
        String checkCpf = scan.nextLine();
        boolean achado = false;

        for (Cliente client : clientList) {
            
            if (checkCpf.contentEquals(client.cpf)){
                System.out.print("Digite o numero de agencia de "+client.nome+" : ");
                int checkAgencia = scan.nextInt();

                for (Conta cont : contaList) {
                    if (checkAgencia==cont.agencia){
                    achado = true;
                    
                    System.out.print("Digite o valor que deseja depositar:");
                    Double deposito = scan.nextDouble();
                    client.conta.saldo = client.conta.saldo+deposito;
                    cont.saldo = cont.saldo+deposito;

                    System.out.print("Deposito efetuado com sucesso!");

                    System.out.print("\n\n[1]Realizar outro deposito\n[2]Voltar para o menu.   [3]Sair.\nEscolha uma das opções: ");
                        int select = scanint.nextInt();

                    switch(select){
                        case 1:{
                        depositoCliente();
                        break;
                        }
                        case 2:{
                        menuSelect();
                        }
                        case 3:{
                        System.out.print("PROGRAMA FINALIZADO COM SUCESSO!");
                        break;
                        }
                    }
                    } 
                }
            }

        
        }
        if (achado == false){
            System.out.print("\nCPF não encontrado. O cliente não possui cadastro.\n[1]Tentar novamente.   [2]Cadastrar cliente.  [3]Voltar para o menu   [3]Sair.\nEscolha a opção desejada:");
            int select = scanint.nextInt();


            switch(select){
                case 1:{
                depositoCliente();
                break;
                }
                case 2:{
                cadastrarCliente();
                break;
                }
                case 3 :{
                menuSelect();
                break;
                }
                case 4:{
                System.out.print("PROGRAMA FINALIZADO COM SUCESSO!");
                }
            }
        }


    }

    public void transfereCliente(){
        Scanner scanRecebe = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);

        System.out.print("\n\nTRANSFERENCIA:");
        System.out.print("\nDigite o cpf do cliente: ");
        String checkCpf = scan.nextLine();
        boolean achado = false;
        boolean achado1 = false;

        for (Cliente client : clientList){
            if(checkCpf.contentEquals(client.cpf)){
                achado = true;
                System.out.print("Digite a agencia de "+client.nome+": ");
                int checkAgencia = scan.nextInt();

                for (Conta cont : contaList) {
                    if(checkAgencia==cont.agencia){
                        achado1 = true;
                        System.out.print("Digite o valor que deseja transerir: ");
                        Double valor = scan.nextDouble();
                        
                        if (valor > client.conta.saldo){
                            System.out.print("Cliente não possui saldo suficiente.\n[1]Tentar novamente   [2]Voltar para o menu.   [3]Sair.\nEscolha uma das opções: ");
                            int select = scan.nextInt();
                            switch(select){
                                case 1:{
                                transfereCliente();
                                break;
                                }
                                case 2:{
                                menuSelect();
                                }
                                case 3:{
                                System.out.print("PROGRAMA FINALIZADO COM SUCESSO!");
                                }    
                            }
                        }// if caso valor for maior
                        client.conta.saldo = client.conta.saldo-valor;
                        cont.saldo = cont.saldo-valor;

                        System.out.print("Digite o cpf dp cliente que deseja fazer a transferencia: ");
                        String recebe = scanRecebe.nextLine();

                        for(Cliente clientRecebe : clientList){
                            if(recebe.contentEquals(clientRecebe.cpf)){
                                System.out.print("Digite a agencia de "+clientRecebe.nome+": ");
                                int checkAgenciaRecebe = scanRecebe.nextInt();

                                for(Conta contRecebe : contaList){
                                    if ( checkAgenciaRecebe==contRecebe.agencia){
                                        contRecebe.saldo = contRecebe.saldo + valor;
                                        clientRecebe.conta.saldo = clientRecebe.conta.saldo + valor;

                                    System.out.print("TRANSFERENCIA REALIZADA COM SUCESSO!");
                                    System.out.print("\n\n[1]Realizar outra transferencia\n[2]Voltar para o menu.   [3]Sair.\nEscolha uma das opções: ");

                                    int selec1 = scanInt.nextInt();
                                    switch(selec1){
                                        case 1:{
                                        transfereCliente();
                                        break;
                                        }
                                        case 2:{
                                        menuSelect();
                                        }
                                        case 3:{
                                        System.out.print("PROGRAMA FINALIZADO COM SUCESSO!");
                                        
                                        }
                                    }

                                    }
                                }

                            }
                        }
                        System.out.print("Cliente não encontrado!\n\n[1]Tentar novamente.    [2]Voltar para o menu.   [4]Sair.\nEscolha a opção desejada:");
            
                        int select = scanInt.nextInt();
                
                            switch(select){
                                case 1:{
                                transfereCliente();
                                break;
                                }
                                case 2:{
                                menuSelect();
                                break;
                                }
                                case 3:{
                                System.out.print("PROGRAMA FINALIZADO COM SUCESSO!");
                                break;}
                                }



                    }//if check agencia 
                }//for contList
                if (achado1 == false){
                    System.out.print("\nINCORRETO!.\n[1]Tentar novamente.    [2]Voltar para o menu.   [4]Sair.\nEscolha a opção desejada:");
            
                    int select = scanInt.nextInt();
            
                        switch(select){
                            case 1:{
                            transfereCliente();
                            break;
                            }
                            case 2:{
                            menuSelect();
                            break;
                            }
                            case 3:{
                            System.out.print("PROGRAMA FINALIZADO COM SUCESSO!");
                            }
                        }
                }
            }//if check CPF
        }//for Client list
        if (achado == false){
            System.out.print("\nCPF não encontrado.\n[1]Tentar novamente.    [2]Voltar para o menu.   [4]Sair.\nEscolha a opção desejada:");
    
            int select = scanInt.nextInt();
    
                switch(select){
                    case 1:{
                    transfereCliente();
                    break;
                    }
                    case 2:{
                    menuSelect();
                    break;
                    }
                    case 3:{
                    System.out.print("PROGRAMA FINALIZADO COM SUCESSO!");
                    }
                }
            }
    }
        


    public void mostrarClientes(){
        int i = 0;
        System.out.println("CLIENTES CADASTRADOS\n"+clientList+"");
        for (Cliente clientes : clientList) {
            i = i+1;
            System.out.printf("Cliente "+i+"\n\nNome :"+clientes.nome+"\nCPF: "+clientes.cpf+"\nProfissão: "+clientes.profissao+"\nAgencia: "+clientes.conta.agencia+"\nSaldo: "+clientes.conta.saldo+"\n\n\n");     
        }
    }


    public void mostrarDados(){
        Scanner scan = new Scanner(System.in);
        Scanner scanint = new Scanner(System.in);


        System.out.print("\n\nMOSTRAR DADOS:\n\nDigite o CPF do cliente que deseja verificar o dados: ");
        String checkCpf = scan.nextLine();
        boolean achado = false;

        for (Cliente client : clientList) {
            
            if (checkCpf.contentEquals(client.cpf)){
                achado = true;
                

                System.out.print("Digite o numero de agencia de "+client.nome+" : ");
                int checkAgencia = scan.nextInt();

                for (Conta cont : contaList) {
                    if (checkAgencia==cont.agencia){
                        System.out.print("Nome: "+client.nome +"\nProfissão: "+ client.profissao +"\nAgencia: " +cont.agencia + "\nSaldo: "+cont.saldo);
                
                        System.out.print("\n\n[1]Ver dados de outro cliente\n[2]Voltar para o menu.   [3]Sair.\nEscolha uma das opções: ");
                        int select = scanint.nextInt();
        
        
                        switch(select){
                            case 1:{
                            mostrarDados();
                            break;
                            }
                            case 2:{
                            menuSelect();
                            }
                            case 3:{
                            System.out.print("PROGRAMA FINALIZADO COM SUCESSO!");
                            }
                        }
                    }   
                }
            }
        }
        if (achado == false){
            System.out.print("\nCPF não encontrado. O cliente não possui cadastro.\n[1]Tentar novamente.    [2]Voltar para o menu.   [4]Sair.\nEscolha a opção desejada:");

            int select = scanint.nextInt();

                switch(select){
                    case 1:{
                    mostrarDados();
                    break;
                    }
                    case 2:{
                    menuSelect();
                    break;
                    }
                    case 3:{
                    System.out.print("PROGRAMA FINALIZADO COM SUCESSO!");
                    }
                }
            }
        
    }

    public void menuSelect(){
        Scanner scanint = new Scanner(System.in);
        System.out.print("\nMENU DE OPÇÕES\n\n");
        System.out.print("[1]Cadastrar cliente\n[2]Cadastrar uma conta para cliente\n[3]Fazer deposito\n[4]Fazer transferencia\n[5]Ver dados do cliente\n[6]Mostrar lista de todos clientes\n[7]Sair\n\nEscolha a opção desejada: ");
        int select = scanint.nextInt();

        switch(select){
            case 1:{
            cadastrarCliente();
            break;
            }
            case 2:{
            cadastroConta();
            break;
            }
            case 3:{
            depositoCliente();
            break;
            }
            case 4:{
            transfereCliente();
            break;
            }
            case 5:{
            mostrarDados();
            break;}
            case 6:{

                mostrarClientes();
            }
            case 7:{
            System.out.print("\nPrograma finalizado com sucesso!");
            }

        }
    }
}

