package sut.sa.g20.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sut.sa.g20.entity.*;
import sut.sa.g20.repository.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.*;
import java.util.stream.Collectors;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class G20Controller {
    //Variable for room count
    private int count = 0;
    private int status = 0;
    //==========FOR PROMOTION===========
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private PromotionRepository promotionRepository;
    @Autowired
    private PromotionTypeRepository promotionTypeRepository;
    @Autowired
    private RoomTypeRepository roomTypeRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private RoomStatusRepository roomStatusRepository;
    @Autowired
    private AdminAccountRepository adminAccountRepository;

    //===========FOR CUSTOMER===========
    @Autowired
    private CountryCodeRepository countryCodeRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SexRepository sexRepository;
    @Autowired
    private TitleNameRepository titleNameRepository;

    //===========FOR HOTEL===========
    @Autowired
    private FurnitureRepository furnitureRepository;
    @Autowired
    private MemberHotelRepository memberHotelRepository;
    @Autowired
    private RoomTypeFurnitureManyToManyRepository roomTypeFurnitureManyToManyRepository;

    //===========FOR RESERVATION===========
    @Autowired
    private ReservationsRepository reservationsRepository;
    @Autowired 
    private StatusPaymentRepository statusPaymentRepository;

    //===========FOR PAYMENT=============
    @Autowired
    private AccountbankRepository accountbankRepository;
    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private TypepaymentRepository typepaymentRepository;

    //============FOR REVIEW=================
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    public G20Controller(HotelRepository hotelRepository, RoomRepository roomRepository, PromotionRepository promotionRepository,
                         PromotionTypeRepository promotionTypeRepository, RoomTypeRepository roomTypeRepository,
                         ProvinceRepository provinceRepository, RoomStatusRepository roomStatusRepository,
                         CountryCodeRepository countryCodeRepository, CustomerRepository customerRepository,
                         SexRepository sexRepository, TitleNameRepository titleNameRepository,
                         FurnitureRepository furnitureRepository, MemberHotelRepository memberHotelRepository,
                         RoomTypeFurnitureManyToManyRepository roomTypeFurnitureManyToManyRepository,
                         ReservationsRepository reservationsRepository, AccountbankRepository accountbankRepository,
                         BankRepository bankRepository, PaymentRepository paymentRepository,
                         TypepaymentRepository typepaymentRepository, AdminAccountRepository adminAccountRepository,
                         ReviewRepository reviewRepository,StatusPaymentRepository statusPaymentRepository){
        //========FOR PROMOTION========
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
        this.promotionRepository = promotionRepository;
        this.promotionTypeRepository = promotionTypeRepository;
        this.roomTypeRepository = roomTypeRepository;
        this.provinceRepository = provinceRepository;
        this.roomStatusRepository = roomStatusRepository;
        this.adminAccountRepository = adminAccountRepository;
        //========FOR CUSTOMER========
        this.countryCodeRepository = countryCodeRepository;
        this.customerRepository = customerRepository;
        this.sexRepository = sexRepository;
        this.titleNameRepository = titleNameRepository;
        //========FOR HOTEL========
        this.furnitureRepository = furnitureRepository;
        this.memberHotelRepository = memberHotelRepository;
        this.roomTypeFurnitureManyToManyRepository = roomTypeFurnitureManyToManyRepository;
        //========FOR RESERVATION========
        this.reservationsRepository = reservationsRepository;
        this.statusPaymentRepository = statusPaymentRepository;
        //========FOR PAYMENT=========
        this.accountbankRepository = accountbankRepository;
        this.bankRepository = bankRepository;
        this.paymentRepository = paymentRepository;
        this.typepaymentRepository = typepaymentRepository;

        //==========================
        this.reviewRepository = reviewRepository;
    }
    //=========================FOR REVIEW===========================
    /*@GetMapping("/hotelsProvince/{province}")
    public Collection<HotelEntity> hotel(@PathVariable String province) {
        long provinceId = provinceRepository.findIdByName(province);
        System.out.print(provinceId);
        return hotelRepository.findHotelByProvinceId(provinceId);
    }*/
    //=========================FOR REVIEW===========================
    @GetMapping("/roomtypes/{roomtypeName}")
    public RoomTypeEntity getRoomType0(@PathVariable String roomtypeName) {
    
        return roomTypeRepository.findByName(roomtypeName);
    }
    //=========================FOR REVIEW===========================
    @GetMapping("/ReservationPaid/{inputEmail}")
    public Collection<ReservationsEntity> getReservationPaid(@PathVariable String inputEmail){
        String statusPayment = "จ่ายแล้ว";
        Long customerId = customerRepository.findCustomerIdByEmail(inputEmail);
        return  reservationsRepository.findReservationByCustomerId(customerId,statusPayment);
    }
    //=========================FOR REVIEW===========================
    @GetMapping("/hotels/{hotelName}")
    public ProvinceEntity getHotemNameEng(@PathVariable String hotelName) {
        Long hotelId = hotelRepository.findByHotelName(hotelName);
        Long provinceId = hotelRepository.findProvinceIdByHotelId(hotelId);


        return provinceRepository.findProvinceById(provinceId);
    }
    //=========================FOR PROMOTION===========================
    @GetMapping(path ="/hotel", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<HotelEntity> Hotel(){
        return hotelRepository.findAll().stream().collect(Collectors.toList());
    }

    //=========================FOR PROMOTION===========================
    @GetMapping(path ="/admin/{adminUsername}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminAccountEntity getAdmin(@PathVariable String adminUsername){
        AdminAccountEntity admin = adminAccountRepository.findByadminUsername(adminUsername);
        return admin;
    }

    //=========================FOR PROMOTION===========================
    @GetMapping(path ="/hotelroom", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<RoomEntity> HotelRoom(){
        return roomRepository.findAll().stream().collect(Collectors.toList());
    }

    //=========================FOR PROMOTION===========================
    @GetMapping(path ="/promotiontype", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<PromotionTypeEntity> PromotionType(){
        return promotionTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    //=========================FOR PROMOTION===========================
    @GetMapping(path ="/roomtype", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<RoomTypeEntity> RoomType(){
        return roomTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    //=========================FOR PROMOTION===========================
    @GetMapping(path ="/promotion")
    public Collection<PromotionEntity> Promotion(){
        return promotionRepository.findAll().stream().collect(Collectors.toList());
    }

    //=========================FOR PROMOTION===========================
    @GetMapping(path ="/province", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ProvinceEntity> Province(){
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }

    //=========================FOR PROMOTION===========================
    @GetMapping(path ="/roomstatus", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<RoomStatusEntity> RoomStatus(){
        return roomStatusRepository.findAll().stream().collect(Collectors.toList());
    }

    //=========================FOR PROMOTION===========================
    @GetMapping(path = "/room/getdata/{hotelSelect}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<RoomTypeEntity> getRoomType(@PathVariable String hotelSelect) {
        HotelEntity hotel = hotelRepository.findByhotelNameEng(hotelSelect);
        Collection<RoomEntity> R = roomRepository.findByhotelEntity(hotel);
        Collection<RoomTypeEntity> type = new ArrayList<>();
        for(RoomEntity room: R){
            if(!(type.contains(room.getRoomTypeEntity()))){
                type.add(room.getRoomTypeEntity());
            }
        }
        System.out.print(type);
        return type.stream().collect(Collectors.toList());
    }

    //=========================FOR PROMOTION===========================
    @PutMapping("/promotion/update/{hotelName}/{roomType}/{promotionType}/{discount}/{dateStart}/{dateEnd}/{detail}/{id}")
    public PromotionEntity newPromotion(@RequestBody PromotionEntity newPromotionEntity, @PathVariable String hotelName,
                                                  @PathVariable String roomType, @PathVariable String promotionType,
                                                  @PathVariable int discount, @PathVariable Date dateStart,
                                                  @PathVariable Date dateEnd, @PathVariable String detail, @PathVariable Long id) {
        PromotionEntity newPromotion = promotionRepository.getOne(id);

        HotelEntity hotelEntity = hotelRepository.findByhotelNameEng(hotelName);
        RoomTypeEntity room = roomTypeRepository.findByroomType(roomType);
        PromotionTypeEntity promoType = promotionTypeRepository.findByPromotionType(promotionType);
        newPromotion.setHotelEntity(hotelEntity);
        newPromotion.setRoomTypeEntity(room);
        newPromotion.setPromotionTypeEntity(promoType);
        newPromotion.setDiscount(discount);
        newPromotion.setDateStart(dateStart);
        newPromotion.setDateEnd(dateEnd);
        newPromotion.setDetail(detail);

        return promotionRepository.save(newPromotion);
    }

    //=========================FOR PROMOTION===========================
    @DeleteMapping("promotion/{id}")
    public void deletePromotion(@PathVariable Long id){
        promotionRepository.deleteById(id);
    }

    //=========================FOR PROMOTION===========================
    @PostMapping("/promotion/{hotelName}/{roomType}/{promotionType}/{discount}/{dateStart}/{dateEnd}/{detail}")
    public PromotionEntity promotion(@RequestBody PromotionEntity newPromotionEntity, @PathVariable String hotelName,
                                     @PathVariable String roomType, @PathVariable String promotionType,
                                     @PathVariable int discount, @PathVariable Date dateStart,
                                     @PathVariable Date dateEnd, @PathVariable String detail) {

        PromotionEntity p = new PromotionEntity();

        HotelEntity hotelEntity = hotelRepository.findByhotelNameEng(hotelName);
        RoomTypeEntity room = roomTypeRepository.findByroomType(roomType);
        PromotionTypeEntity promoType = promotionTypeRepository.findByPromotionType(promotionType);

        p.setHotelEntity(hotelEntity);
        p.setRoomTypeEntity(room);
        p.setPromotionTypeEntity(promoType);
        p.setDiscount(discount);
        p.setDateStart(dateStart);
        p.setDateEnd(dateEnd);
        p.setDetail(detail);

        return promotionRepository.save(p);
    }

    //==================FOR CUSTOMER===================
    @GetMapping(path = "/countryCode", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CountryCodeEntity> CountryCode(){
        return countryCodeRepository.findAll().stream().collect(Collectors.toList());
    }
    //==================FOR CUSTOMER===================
    @GetMapping(path = "/customerlogin/{email}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean isLogin(@PathVariable String email,@PathVariable String password){
        Long customerId = customerRepository.findCustomerIdByEmailPass(email,password);
        if(customerId != null)
            return true;
        return false;
    }

    //==================FOR CUSTOMER===================
    @GetMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CustomerEntity> Customer(){
        return customerRepository.findAll().stream().collect(Collectors.toList());
    }

    //==================FOR CUSTOMER===================
    @GetMapping(path = "/sex", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<SexEntity> Sex(){
        return sexRepository.findAll().stream().collect(Collectors.toList());
    }

    //==================FOR CUSTOMER===================
    @GetMapping(path = "/TitleNameEntity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TitleNameEntity> TitleName(){
        return titleNameRepository.findAll().stream().collect(Collectors.toList());
    }

    //==================FOR CUSTOMER===================
    @PostMapping("/customer/{titleName}/{customerName}/{sex}/{email}/{pass}/{countryCode}/{phone}/{address}")
    public CustomerEntity customer(@RequestBody CustomerEntity cus, @PathVariable String titleName, @PathVariable String customerName,
                                   @PathVariable String sex, @PathVariable String email, @PathVariable String pass, @PathVariable Long countryCode,
                                   @PathVariable String phone, @PathVariable String address) {
        CustomerEntity customerEntity = new CustomerEntity();
        TitleNameEntity title = titleNameRepository.findBytitlename(titleName);
        CountryCodeEntity countrycode = countryCodeRepository.findBycountrycodeid(countryCode);
        SexEntity csex = sexRepository.findBycustomersex(sex);

        customerEntity.setTitleName(title);
        customerEntity.setCustomername(customerName);
        customerEntity.setCustomeremail(email);
        customerEntity.setCountry(countrycode);
        customerEntity.setCustomerphone(phone);
        customerEntity.setCustomeraddress(address);
        customerEntity.setCustomersex(csex);
        customerEntity.setCustomerpass(pass);

        return customerRepository.save(customerEntity);
    }

    //==================FOR HOTEL===================
    @GetMapping("/furniture/{name}")
    public FurnitureEntity newFurniture(@PathVariable final String  name){
        FurnitureEntity set = new FurnitureEntity();
        set.setFurnitureName(name);
        return furnitureRepository.save(set);
    }

    //==================FOR HOTEL===================
    @GetMapping("/furnitures")
    public Collection<FurnitureEntity> Furniture() {
        return furnitureRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    //==================FOR HOTEL===================
    @GetMapping("/hotel/{hotelNameThai}/{name}/{villageNo}/{houseNo}/{building}/{village}/{alleyLane}/{road}/{subDistrictSubArea}/{districtArea}/{postCode}/{mobilePhone}/{phone}/{fax}/{province}/{memberName}")
    public HotelEntity newHotel(@PathVariable final String  name,@PathVariable String province,@PathVariable int villageNo
            ,@PathVariable String houseNo, @PathVariable String building, @PathVariable String village, @PathVariable String alleyLane,
                                @PathVariable String road, @PathVariable String subDistrictSubArea, @PathVariable String districtArea, @PathVariable int postCode,
                                @PathVariable String mobilePhone, @PathVariable String phone, @PathVariable String fax, @PathVariable String hotelNameThai,@PathVariable String memberName){
        ProvinceEntity p = provinceRepository.findByName(province);
        MemberHotelEntity member = memberHotelRepository.findByName(memberName);
        HotelEntity hotels = new HotelEntity();
        hotels.setHotelNameThai(hotelNameThai);
        hotels.setHotelNameEng(name);
        hotels.setVillageNo(villageNo);
        hotels.setHouseNo(houseNo);
        hotels.setBuilding(building);
        hotels.setVillage(village);
        hotels.setAlleyLane(alleyLane);
        hotels.setRoad(road);
        hotels.setSubDistrictSubArea(subDistrictSubArea);
        hotels.setDistrictArea(districtArea);
        hotels.setPostCode(postCode);
        hotels.setMobilePhone(mobilePhone);
        hotels.setPhone(phone);
        hotels.setFax(fax);
        hotels.setProvinceEntity(p);
        hotels.setMemberHotel(member);
        return hotelRepository.save(hotels);
    }

    //==================FOR HOTEL===================
    @GetMapping("/hotels")
    public Collection<HotelEntity> hotel() {
        return hotelRepository.findAll().stream().collect(Collectors.toList());
    }


    //==================FOR HOTEL===================
    @GetMapping("/memberhotels")
    public Collection<MemberHotelEntity> memberhotel() {
        return memberHotelRepository.findAll().stream().collect(Collectors.toList());
    }

    //==================FOR HOTEL===================
    @GetMapping("/memberhotel/{username}/{password}")
    public MemberHotelEntity newMember(@PathVariable String username,@PathVariable Long password){
        MemberHotelEntity member = new MemberHotelEntity();
        member.setMemberHotelName(username);
        member.setMemberHotelPassword(password);
        return memberHotelRepository.save(member);
    }

    //==================FOR HOTEL===================
    @GetMapping("/memberlogin/{username}/{password}")
    public Boolean isLogin(@PathVariable String username,@PathVariable Long password){
        Long m = memberHotelRepository.isLogin(username,password);
        if(m!=null)
            return true;
        return false;
    }

    //==================FOR HOTEL===================
    @GetMapping("/provinces")
    public Collection<ProvinceEntity> provinces() {
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }

    //==================FOR HOTEL===================
    @GetMapping("/province/{name}")
    public ProvinceEntity newProvince(@PathVariable String name) {
        ProvinceEntity p = new ProvinceEntity();
        p.setProvinceName(name);
        return this.provinceRepository.save(p);
    }

    //==================FOR HOTEL===================
    @PostMapping("/room/{roomType}/{roomstatus}/{number}/{price}/{roomImg}/{memberUserName}")
    public Boolean update(@RequestBody String room,@PathVariable String memberUserName, @PathVariable String roomType, @PathVariable String roomstatus, @PathVariable final int number, @PathVariable int price,@PathVariable String roomImg)throws JsonParseException, IOException {
        final String decoded = URLDecoder.decode(room, "UTF-8");
        room = decoded;

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(room);
        JsonNode jsonImg = actualObj.get("imgSelect");

        if(count != 0) {
            Long mem = memberHotelRepository.findId(memberUserName);
            Long hotelIdFromName = hotelRepository.findHotelIdByMemId(mem);
            System.out.println(hotelIdFromName);
            Long hotelIdFromeId = roomRepository.findByHotelId(hotelIdFromName,number);
            System.out.println(hotelIdFromeId);
            if(hotelIdFromeId != null )
                status = 1;
            else
                status = 0;
        }
        if(status == 0) {
            Long mem = memberHotelRepository.findId(memberUserName);
            RoomStatusEntity rst = roomStatusRepository.findByName(roomstatus);
            HotelEntity hotels = hotelRepository.findHotelByMemberId(mem);
            RoomTypeEntity rt = roomTypeRepository.findByName(roomType);
            RoomEntity no1 = new RoomEntity();
            no1.setRoomNumber(number);
            no1.setRoomPrice(price);
            no1.setHotel(hotels);
            no1.setRoomTypeEntity(rt);
            no1.setRoomStatusEntity(rst);
            no1.setRoomImg(jsonImg.textValue());
            roomRepository.save(no1);
            roomRepository.findAll().stream().collect(Collectors.toList());
            count++;
            return true;
        }
        return false;
    }

    //==================FOR HOTEL===================
    @GetMapping("/rooms")
    public Collection<RoomEntity> Rooms() {
        return roomRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    //==================FOR HOTEL===================
    @PutMapping("/updateroomstatus/{roomId}/{hotel}/{roomType}/{roomstatus}/{number}/{price}")
    public RoomEntity editRoom(@RequestBody RoomEntity room,@PathVariable Long roomId,@PathVariable String hotel, @PathVariable String roomType, @PathVariable String roomstatus, @PathVariable final int number, @PathVariable int price){
        HotelEntity ho = hotelRepository.findByName(hotel);
        RoomTypeEntity rt = roomTypeRepository.findByName(roomType);
        RoomStatusEntity rst = roomStatusRepository.findByName(roomstatus);
        return roomRepository.findById(roomId).map(roomedit ->{
                    roomedit.setRoomNumber(number);
                    roomedit.setRoomPrice(price);
                    roomedit.setRoomStatusEntity(rst);
                    roomedit.setHotel(ho);
                    roomedit.setRoomTypeEntity(rt);
                    return roomRepository.save(roomedit);
                }
        ).orElseGet(() ->{
            return roomRepository.save(room);
        });
    }

    //==================FOR HOTEL===================
    @GetMapping("/roomstatuses")
    public Collection<RoomStatusEntity> roomStatus() {
        return roomStatusRepository.findAll().stream().collect(Collectors.toList());
    }

    //==================FOR HOTEL===================
    @GetMapping("/roomstatus/{name}")
    public RoomStatusEntity newRoomStatus(@PathVariable String name) {
        RoomStatusEntity rst = new RoomStatusEntity();
        rst.setRoomStatus(name);
        return this.roomStatusRepository.save(rst);
    }

    //==================FOR HOTEL===================
    @GetMapping("/roomtype/{rt}/{bedType}/{numberOfBed}/{maxPeople}")
    public RoomTypeEntity newRoomType(@PathVariable final String  rt,@PathVariable String bedType,@PathVariable int numberOfBed,@PathVariable int maxPeople){
        RoomTypeEntity roomType = new RoomTypeEntity();
        roomType.setRoomType(rt);
        roomType.setBedType(bedType);
        roomType.setNumberOfBed(numberOfBed);
        roomType.setMaxPeople(maxPeople);
        return roomTypeRepository.save(roomType);
    }

    //==================FOR HOTEL===================
    @GetMapping("/roomtypes")
    public Collection<RoomTypeEntity> RoomTypes() {
        return roomTypeRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    //==================FOR HOTEL===================
    @GetMapping("/roomtypefurniture/{roomtype}/{furniture}")
    public RoomTypeFurnitureManyToManyEntity newRoomType(@PathVariable final String  roomtype, @PathVariable final String furniture){
        FurnitureEntity fr = furnitureRepository.findByName(furniture);
        RoomTypeEntity rt = roomTypeRepository.findByName(roomtype);
        RoomTypeFurnitureManyToManyEntity rtf = new RoomTypeFurnitureManyToManyEntity();
        rtf.setFurnitureFurnitureRoomTypeManyMany(fr);
        rtf.setRoomtypeFurnitureMany(rt);
        return roomTypeFurnitureManyToManyRepository.save(rtf);
    }

    //==================FOR HOTEL===================
    @GetMapping("/roomtypefurnitures")
    public Collection<RoomTypeFurnitureManyToManyEntity> roomtype_furniture() {
        return roomTypeFurnitureManyToManyRepository.findAll().stream().collect(Collectors.toList());
    }



    //==================FOR PRACH===================
    @GetMapping("/Reservations")
    public Collection<ReservationsEntity> Reservations(){
        return  reservationsRepository.findAll().stream().collect(Collectors.toList());
    }

    //==================FOR PRACH===================
    @GetMapping("/Reservations/{inputEmail}")
    public Collection<ReservationsEntity> Reservations0(@PathVariable String inputEmail){
        String statusPayment = "ยังไม่จ่าย";
        System.out.println(inputEmail);
        Long customerId = customerRepository.findCustomerIdByEmail(inputEmail);
        System.out.print(customerId);
        return  reservationsRepository.findReservationByCustomerId(customerId,statusPayment);
    }

    //==================FOR PRACH===================
    @GetMapping("/Reservations/{customeremail}/{hotel}/{roomtype}/{detail}/{numberofpeople}/{numberofroom}/{dateStart}/{dateEnd}")
    public Boolean newReser(@PathVariable String customeremail,@PathVariable String hotel,@PathVariable String roomtype,@PathVariable String detail,@PathVariable int numberofpeople,@PathVariable int numberofroom
            ,@PathVariable Date dateStart,@PathVariable Date dateEnd){
        //CustomerEntity cs = customerRepository.findBycustomerid(cus_id);
        HotelEntity ht = hotelRepository.findByName(hotel);
        StatusPaymentEntity stp = statusPaymentRepository.findByName("ยังไม่จ่าย");
        System.out.print("status");
        System.out.print(stp);
        int discountPro =  0;
        CustomerEntity cus = customerRepository.findBycustomeremail(customeremail);
        long hotelid = hotelRepository.findByHotelName(hotel);
        RoomTypeEntity rt = roomTypeRepository.findRoomTypeByName(roomtype);
        long roomtypeid = roomTypeRepository.findIdByName(roomtype);
        Collection<RoomEntity> room = roomRepository.findRoomByHotelIdRoomTypeId(hotelid, roomtypeid,1L);
        String RoomString = room.stream().findFirst().toString();
        long roomId;
        if(RoomString.charAt(RoomString.indexOf("roomId") + 8)<0|| RoomString.charAt(RoomString.indexOf("roomId") + 8)> 10)
            roomId = RoomString.charAt(RoomString.indexOf("roomId") + 7) - '0';
        else
            roomId = (RoomString.charAt(RoomString.indexOf("roomId") + 7) - '0')*10 + (RoomString.charAt(RoomString.indexOf("roomId") + 8)- '0');

        if(room.isEmpty()) {
            return false;
        }
        else{
            System.out.println("do");
            System.out.println(detail);
            if(detail.equals("0")){
                System.out.println("wow");
                System.out.println(discountPro);
                ReservationsEntity rs = new ReservationsEntity();
                int roomPrice = roomRepository.findRoomPriceById(roomId);
                rs.setRoomTypeEntity(rt);
                rs.setStatusPaymentEntity(stp);
                rs.setHoteltype(ht);
                rs.setCustomertype(cus);
                rs.setNumberOfPeople(numberofpeople);
                rs.setNumberOfRoom(numberofroom);
                rs.setDateStart(dateStart);
                rs.setDateEnd(dateEnd);
                rs.setRoomPrice(roomPrice);
                reservationsRepository.save(rs);
                RoomStatusEntity rst = roomStatusRepository.findByName("จอง");
                roomRepository.findById(roomId).map(roomedit ->{
                            roomedit.setRoomStatusEntity(rst);
                            roomRepository.save(roomedit);
                            return true;
                        }
                ).orElseGet(() ->{
                    return  true;
                });
            }
            else {
                PromotionEntity pr = promotionRepository.findBydetail(detail);
                Long proId = promotionRepository.findId(detail);
                discountPro = promotionRepository.findDiscount(proId);
                System.out.println(discountPro);
                ReservationsEntity rs = new ReservationsEntity();
                int roomPrice = roomRepository.findRoomPriceById(roomId);
                roomPrice = roomPrice-(roomPrice*discountPro/100);
                rs.setRoomTypeEntity(rt);
                rs.setStatusPaymentEntity(stp);
                rs.setHoteltype(ht);
                rs.setPromotion(pr);
                rs.setCustomertype(cus);
                rs.setNumberOfPeople(numberofpeople);
                rs.setNumberOfRoom(numberofroom);
                rs.setDateStart(dateStart);
                rs.setDateEnd(dateEnd);
                rs.setRoomPrice(roomPrice);
                reservationsRepository.save(rs);

                RoomStatusEntity rst = roomStatusRepository.findByName("จอง");
                roomRepository.findById(roomId).map(roomedit ->{
                            roomedit.setRoomStatusEntity(rst);
                            roomRepository.save(roomedit);
                            return true;
                        }
                ).orElseGet(() ->{
                    return  true;
                });
            }
        }
        return  true;
    }
    //==================FOR PRACH===================
    @GetMapping(path = "/promotion/getdata/{hotelSelect}/{roomTypeSelect}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<PromotionEntity> getPromotionFromHotel(@PathVariable String hotelSelect, @PathVariable String roomTypeSelect) {
        HotelEntity hotel = hotelRepository.findByhotelNameEng(hotelSelect);
        RoomTypeEntity rt = roomTypeRepository.findByroomType(roomTypeSelect);
        Collection<PromotionEntity> R = promotionRepository.findByhotelEntityAndRoomTypeEntity(hotel,rt);
        System.out.println(R);
        return R.stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/Accountbank", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<AccountbankEntity> accountbankEntities() {
        return accountbankRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping(path = "/BankEntity/{bankname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BankEntity bank(BankEntity b,@PathVariable String bankname){
        b = bankRepository.findByBankname(bankname);
        return b;
    }

    @GetMapping(path = "/BankEntity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<BankEntity> Bank() {
        return bankRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/payment/{inputEmail}/{accountnum}/{name}/{lastname}/{address}/{phonenum}/{bankname}/{typename}/{reservationsid}")
    public Boolean payment(PaymentEntity p,ReservationsEntity reservationEntity, @PathVariable String inputEmail,@PathVariable String accountnum, @PathVariable String name, @PathVariable String lastname, @PathVariable String address, @PathVariable int phonenum,  @PathVariable String bankname, @PathVariable String typename, @PathVariable Long reservationsid){
       
       StatusPaymentEntity rst = statusPaymentRepository.findByName("จ่ายแล้ว");
       BankEntity bank = bankRepository.findByBankname(bankname);
       System.out.println(bank);
       TypepaymentEntity type = typepaymentRepository.findByTypename(typename);
       System.out.println(type);
       ReservationsEntity reser = reservationsRepository.findByReservationsId(reservationsid);
       System.out.println(reser);
       AccountbankEntity acc = accountbankRepository.findByaccountNumberAndBank(accountnum, bank);
       Long customerId = customerRepository.findCustomerIdByEmail(inputEmail);
       CustomerEntity customer = customerRepository.findBycustomerid(customerId);
        if(acc == null)
            return false;
        else{
            
            p.setCustomerEntity(customer);
            p.setAccountbankEntity(acc);
            p.setTypepayments(type);
            p.setReservation(reser);
            p.setName(name);
            p.setLastname(lastname);
            p.setAddress(address);
            p.setPhonenum(phonenum);
            paymentRepository.save(p);
            reservationsRepository.findById(reservationsid).map(reservation ->{
                reservation.setStatusPaymentEntity(rst);
                reservationsRepository.save(reservation);
                return true;
            }
            ).orElseGet(() ->{
                reservationsRepository.save(reservationEntity);
                return true;
            });
            return true;
        }
    }

    @GetMapping(path = "/Reservation", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<ReservationsEntity> Reservation() {
        return reservationsRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/TypepaymentEntity", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TypepaymentEntity> Typepayment() {
        return typepaymentRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/bills")
    public Collection<PaymentEntity> Bills() {
        return paymentRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/users")
    public Collection<CustomerEntity>users() {
        return customerRepository.findAll().stream().collect(Collectors.toList());
    }


    @GetMapping("/Reviews")
    public Collection<ReviewEntity> Reviews() {
        return reviewRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Review/{comment}/{score}/{userName}/{roomType}/{hotelName}/{billName}")
    public ReviewEntity newReview(@PathVariable String userName, String comment, int score, String roomType,
                                  String hotelName, String billName) {
        CustomerEntity user = customerRepository.findByUser(userName);
        RoomTypeEntity room = roomTypeRepository.findByName(roomType);
        HotelEntity hotel = hotelRepository.findByName(hotelName);
        PaymentEntity bill = paymentRepository.findByBillName(billName);
        ReviewEntity r = new ReviewEntity(comment, score, user, room, hotel, bill);
        return this.reviewRepository.save(r);
    }

    @GetMapping("/review/createreview/{inputEmail}/{billId}/{hotel}/{roomtype}/{comment}/{problem}/{service1}/{service2}/{service3}/{room1}/{room2}/{room3}/{secu1}/{secu2}/{secu3}")
    public ReviewEntity newReview2(@PathVariable String hotel,@PathVariable String roomtype,@PathVariable String comment,
                                   @PathVariable String problem, @PathVariable int service1,@PathVariable int service2,@PathVariable int service3,@PathVariable int room1,@PathVariable int room2,@PathVariable int room3,@PathVariable int secu1,
                                   @PathVariable int secu2,@PathVariable int secu3,@PathVariable Long billId,@PathVariable String inputEmail) {
        float score = 0;
        int s[] = { service1, service2, service3, room1, room2, room3, secu1, secu2, secu3 };
        for (int i = 0; i < s.length; i++) {
            score += (float)s[i];
        }
        CustomerEntity cus = customerRepository.findBycustomeremail(inputEmail);
        float sumscore = score / 9;
        RoomTypeEntity room = roomTypeRepository.findByName(roomtype);
        HotelEntity hotel2 = hotelRepository.findByName(hotel);
        PaymentEntity bill = paymentRepository.findBillById(billId);
        ReviewEntity re=new ReviewEntity();
        re.setUser(cus);
        re.setPaymentEntity(bill);
        re.setHotelNameEng(hotel2);
        re.setScore(sumscore);
        re.setComment(comment);
        re.setRoomtype(room);
        return this.reviewRepository.save(re);
    }
}
