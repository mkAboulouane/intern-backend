//package fst.sir.stage_back.service.admin.impl;
//
//import fst.sir.stage_back.bean.Client;
//import fst.sir.stage_back.dao.ClientDao;
//import fst.sir.stage_back.service.admin.facade.ClientAdminService;
//import fst.sir.stage_back.util.ListUtil;
//import fst.sir.stage_back.util.StringUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class ClientAdminServiceImpl implements ClientAdminService {
//
//    @Autowired
//    private ClientDao clientDao;
//
//
//    public void update(List<Client> clients) {
//        if (ListUtil.isNotEmpty(clients)) {
//            clients.forEach(e -> clientDao.save(e));
//        }
//    }
//
//    public Client save(Client client) {
//        Client result = null;
//        Client foundedClient = findByUsername(client.getUsername());
//        if (foundedClient == null) {
//            Client savedClient = clientDao.save(client);
//            result = savedClient;
//        }
//        return result;
//    }
//
//    public List<Client> save(List<Client> clients) {
//        List<Client> list = new ArrayList<>();
//        for (Client client : clients) {
//            list.add(save(client));
//        }
//        return list;
//    }
//
//
//    @Override
//    public Client findByUsername(String username) {
//        if( username== null) return null;
//       else return clientDao.findByUsername(username);    }
//
//    @Override
//    public int deleteByUsername(String username) {
//        return 0;
//    }
//
//    @Override
//    public Client findByIdOrReference(Client client) {
//        Client resultat=null;
//        if(client != null){
//            if(StringUtil.isNotEmpty(client.getId())){
//                resultat= clientDao.getOne(client.getId());
//            }else if(StringUtil.isNotEmpty(client.getUsername())) {
//                resultat= clientDao.findByUsername(client.getUsername());
//            }
//        }
//        return resultat;
//    }
//
//    public Client findById(Long id){
//        if(id==null) return null;
//        return clientDao.getOne(id);
//    }
//
//    @Transactional
//    public int deleteById(Long id){
//        int res=0;
//        if(clientDao.findById(id).isPresent())  {
//            clientDao.deleteById(id);
//            res = 1;
//        }
//        return res;
//    }
//
//
//}
