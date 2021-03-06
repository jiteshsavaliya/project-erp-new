package com.erp.service.master.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.controller.master.MasterController;
import com.erp.domain.master.AccountMaster;
import com.erp.domain.master.AddressMaster;
import com.erp.domain.master.CategoryMaster;
import com.erp.domain.master.CompanyMaster;
import com.erp.domain.master.CustomerMaster;
import com.erp.domain.master.ProductMaster;
import com.erp.domain.master.RouteMaster;
import com.erp.repository.master.AccountMasterRepository;
import com.erp.repository.master.AddressMasterRepository;
import com.erp.repository.master.CategoryMasterRepository;
import com.erp.repository.master.CompanyMasterRepository;
import com.erp.repository.master.CustomerMasterRepository;
import com.erp.repository.master.ProductMasterRepository;
import com.erp.repository.master.RouteMasterRepository;
import com.erp.service.master.MasterService;

import model.AccountMasterRequest;
import model.AddressMasterRequest;
import model.CategoryMasterRequest;
import model.CompanyMasterRequest;
import model.CustomerMasterRequest;
import model.ErpResponse;
import model.MasterModel;
import model.ProductMasterRequest;
import model.RouteMasterRequest;
import utils.CommonUtils;
import utils.MultipleJSONObjectHelper;

@Service
@Transactional
public class MasterServiceImpl implements MasterService {

	private static Logger log = LoggerFactory.getLogger(MasterController.class);

	@Autowired
	private AccountMasterRepository accountMasterRepository;

	@Autowired
	private AddressMasterRepository addressMasterRepository;

	@Autowired
	private CategoryMasterRepository categoryMasterRepository;

	@Autowired
	private CompanyMasterRepository companyMasterRepository;

	@Autowired
	private CustomerMasterRepository customerMasterRepository;

	@Autowired
	private ProductMasterRepository productMasterRepository;

	@Autowired
	private RouteMasterRepository routeMasterRepository;

	@Override
	public ErpResponse get(Long id, Integer classId) {
		// TODO Auto-generated method stub

		try {

			switch (classId) {
			case 1: {
				// for get AccountMasterRequest Details
				AccountMasterRequest accountMasterRequest = new AccountMasterRequest();
				AccountMaster accountMaster = accountMasterRepository.findOne(id);
				BeanUtils.copyProperties(accountMaster, accountMasterRequest);

				ErpResponse res = new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setData(accountMasterRequest);
				return res;

			}
			case 2: {
				// for get AddressMasterRequest Details
				AddressMasterRequest addressMasterRequest = new AddressMasterRequest();
				AddressMaster addressMaster = addressMasterRepository.findOne(id);
				BeanUtils.copyProperties(addressMaster, addressMasterRequest);

				ErpResponse res = new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setData(addressMasterRequest);
				return res;

			}
			case 3: {
				// for get CategoryMasterRequest Details
				CategoryMasterRequest categoryMasterRequest = new CategoryMasterRequest();
				CategoryMaster categoryMaster = categoryMasterRepository.findOne(id);
				BeanUtils.copyProperties(categoryMaster, categoryMasterRequest);

				ErpResponse res = new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setData(categoryMasterRequest);
				return res;

			}
			case 4: {
				// for get CompanyMasterRequest Details
				CompanyMasterRequest companyMasterRequest = new CompanyMasterRequest();
				CompanyMaster companyMaster = companyMasterRepository.findOne(id);
				BeanUtils.copyProperties(companyMaster, companyMasterRequest);

				ErpResponse res = new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setData(companyMasterRequest);
				return res;

			}
			case 5: {
				// for get CustomerMasterRequest Details
				CustomerMasterRequest customerMasterRequest = new CustomerMasterRequest();
				CustomerMaster customerMaster = customerMasterRepository.findOne(id);
				BeanUtils.copyProperties(customerMaster, customerMasterRequest);

				ErpResponse res = new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setData(customerMasterRequest);
				return res;

			}
			case 6: {
				// for get ProductMasterRequest Details
				ProductMasterRequest productMasterRequest = new ProductMasterRequest();
				ProductMaster productMaster = productMasterRepository.findOne(id);
				BeanUtils.copyProperties(productMaster, productMasterRequest);

				ErpResponse res = new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setData(productMasterRequest);
				return res;

			}
			case 7: {
				// for get RouteMasterRequest Details
				RouteMasterRequest routeMasterRequest = new RouteMasterRequest();
				RouteMaster routeMaster = routeMasterRepository.findOne(id);
				BeanUtils.copyProperties(routeMaster, routeMasterRequest);

				ErpResponse res = new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setData(routeMaster);
				return res;

			}
			}

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
			log.error("error while fetching master detail");
			return new ErpResponse("Error while fetching master detail", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return null;
	}

	@Override
	public ErpResponse list(Integer classId, Integer pageSize, Integer pageNo) {
		// TODO Auto-generated method stub

		Pageable pageable = new PageRequest(pageNo, pageSize);
		try {

			switch (classId) {
			case 1: {
				List<AccountMasterRequest> listOfAccountMasterRequest = new ArrayList<AccountMasterRequest>();
				List<AccountMaster> listOfAccountMaster = new ArrayList<AccountMaster>();
				if (pageSize == -1 || pageNo == -1) {
					listOfAccountMaster = accountMasterRepository.listAll();
				} else {

					listOfAccountMaster = accountMasterRepository.listByRange(pageable);
				}

				for (AccountMaster accountMaster : listOfAccountMaster) {
					AccountMasterRequest accountMasterRequest = new AccountMasterRequest();
					BeanUtils.copyProperties(accountMaster, accountMasterRequest);
					listOfAccountMasterRequest.add(accountMasterRequest);
				}

				ErpResponse res = new ErpResponse(CommonUtils.LIST_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setDataList(listOfAccountMasterRequest);
				return res;
			}
			case 2: {
				List<AddressMasterRequest> listOfAddressMasterRequest = new ArrayList<AddressMasterRequest>();
				List<AddressMaster> listOfAddressMaster = new ArrayList<AddressMaster>();
				if (pageSize == -1 || pageNo == -1) {
					listOfAddressMaster = addressMasterRepository.listAll();
				} else {
					listOfAddressMaster = addressMasterRepository.listByRange(pageable);
				}

				for (AddressMaster addressMaster : listOfAddressMaster) {
					AddressMasterRequest addressMasterRequest = new AddressMasterRequest();
					BeanUtils.copyProperties(addressMaster, addressMasterRequest);
					listOfAddressMasterRequest.add(addressMasterRequest);
				}

				ErpResponse res = new ErpResponse(CommonUtils.LIST_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setDataList(listOfAddressMasterRequest);
				return res;
			}
			case 3: {
				List<CategoryMasterRequest> listOfCategoryMasterRequest = new ArrayList<CategoryMasterRequest>();
				List<CategoryMaster> listOfCategoryMaster = new ArrayList<CategoryMaster>();
				if (pageSize == -1 || pageNo == -1) {
					listOfCategoryMaster = categoryMasterRepository.listAll();
				} else {
					listOfCategoryMaster = categoryMasterRepository.listByRange(pageable);
				}

				for (CategoryMaster categoryMaster : listOfCategoryMaster) {
					CategoryMasterRequest categoryMasterRequest = new CategoryMasterRequest();
					BeanUtils.copyProperties(categoryMaster, categoryMasterRequest);
					listOfCategoryMasterRequest.add(categoryMasterRequest);
				}

				ErpResponse res = new ErpResponse(CommonUtils.LIST_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setDataList(listOfCategoryMasterRequest);
				return res;
			}
			case 4: {
				List<CompanyMasterRequest> listOfCompanyMasterRequest = new ArrayList<CompanyMasterRequest>();
				List<CompanyMaster> listOfCompanyMaster = new ArrayList<CompanyMaster>();
				if (pageSize == -1 || pageNo == -1) {
					listOfCompanyMaster = companyMasterRepository.listAll();
				} else {
					listOfCompanyMaster = companyMasterRepository.listByRange(pageable);
				}

				for (CompanyMaster companyMaster : listOfCompanyMaster) {
					CompanyMasterRequest companyMasterRequest = new CompanyMasterRequest();
					BeanUtils.copyProperties(companyMaster, companyMasterRequest);
					listOfCompanyMasterRequest.add(companyMasterRequest);
				}

				ErpResponse res = new ErpResponse(CommonUtils.LIST_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setDataList(listOfCompanyMasterRequest);
				return res;
			}

			case 5: {
				List<CustomerMasterRequest> listOfCustomerMasterRequest = new ArrayList<CustomerMasterRequest>();
				List<CustomerMaster> listOfCustomerMaster = new ArrayList<CustomerMaster>();
				if (pageSize == -1 || pageNo == -1) {
					listOfCustomerMaster = customerMasterRepository.listAll();
				} else {
					listOfCustomerMaster = customerMasterRepository.listByRange(pageable);
				}

				for (CustomerMaster customerMaster : listOfCustomerMaster) {
					CustomerMasterRequest customerMasterRequest = new CustomerMasterRequest();
					BeanUtils.copyProperties(customerMaster, customerMasterRequest);
					listOfCustomerMasterRequest.add(customerMasterRequest);
				}

				ErpResponse res = new ErpResponse(CommonUtils.LIST_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setDataList(listOfCustomerMasterRequest);
				return res;
			}

			case 6: {
				List<ProductMasterRequest> listOfProductMasterRequest = new ArrayList<ProductMasterRequest>();
				List<ProductMaster> listOfProductMaster = new ArrayList<ProductMaster>();
				if (pageSize == -1 || pageNo == -1) {
					listOfProductMaster = productMasterRepository.listAll();
				} else {
					listOfProductMaster = productMasterRepository.listByRange(pageable);
				}

				for (ProductMaster productMaster : listOfProductMaster) {
					ProductMasterRequest productMasterRequest = new ProductMasterRequest();
					BeanUtils.copyProperties(productMaster, productMasterRequest);
					listOfProductMasterRequest.add(productMasterRequest);
				}

				ErpResponse res = new ErpResponse(CommonUtils.LIST_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setDataList(listOfProductMasterRequest);
				return res;
			}

			case 7: {
				List<RouteMasterRequest> listOfRouteMasterRequest = new ArrayList<RouteMasterRequest>();
				List<RouteMaster> listOfRouteMaster = new ArrayList<RouteMaster>();
				if (pageSize == -1 || pageNo == -1) {
					listOfRouteMaster = routeMasterRepository.listAll();
				} else {
					listOfRouteMaster = routeMasterRepository.listByRange(pageable);
				}

				for (RouteMaster routeMaster : listOfRouteMaster) {
					RouteMasterRequest routeMasterRequest = new RouteMasterRequest();
					BeanUtils.copyProperties(routeMaster, routeMasterRequest);
					listOfRouteMasterRequest.add(routeMasterRequest);
				}

				ErpResponse res = new ErpResponse(CommonUtils.LIST_SUCCESSFULLY_FETCHED, HttpStatus.OK.value());
				res.setDataList(listOfRouteMasterRequest);
				return res;
			}

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("error while fetching list of master detail");
			return new ErpResponse("Error while fetching list of master detail",
					HttpStatus.INTERNAL_SERVER_ERROR.value());
		}
		return null;
	}

	@Override
	public ErpResponse inactive(Long id, Integer classId) {
		// TODO Auto-generated method stub

		try {

			switch (classId) {
			case 1: {
				int count = accountMasterRepository.setInActive(id);
				ErpResponse res = new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_INACTIVATED, HttpStatus.OK.value());
				return res;

			}
			case 2: {
				int count = addressMasterRepository.setInActive(id);
				ErpResponse res = new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_INACTIVATED, HttpStatus.OK.value());
				return res;

			}
			case 3: {
				int count = categoryMasterRepository.setInActive(id);
				ErpResponse res = new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_INACTIVATED, HttpStatus.OK.value());
				return res;

			}
			case 4: {
				int count = companyMasterRepository.setInActive(id);
				ErpResponse res = new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_INACTIVATED, HttpStatus.OK.value());
				return res;

			}
			case 5: {
				int count = customerMasterRepository.setInActive(id);
				ErpResponse res = new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_INACTIVATED, HttpStatus.OK.value());
				return res;

			}
			case 6: {
				int count = productMasterRepository.setInActive(id);
				ErpResponse res = new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_INACTIVATED, HttpStatus.OK.value());
				return res;

			}
			case 7: {
				int count = routeMasterRepository.setInActive(id);
				ErpResponse res = new ErpResponse(CommonUtils.DATA_SUCCESSFULLY_INACTIVATED, HttpStatus.OK.value());
				return res;

			}
			}

		} catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();
			log.error("error while set inactive master detail");
			return new ErpResponse("Error while set inactive master detail", HttpStatus.INTERNAL_SERVER_ERROR.value());
		}

		return null;
	}

	@Override
	public Boolean save(MasterModel request) {
		// TODO Auto-generated method stub

		try {

			switch (request.getClassId()) {
			case 1: {
				AccountMasterRequest accountMasterRequest = new AccountMasterRequest();
				accountMasterRequest = (AccountMasterRequest) MultipleJSONObjectHelper
						.getObjectFromMap((Map<String, Object>) request.getMaster(), AccountMasterRequest.class);

				AccountMaster accountMaster = new AccountMaster();
				BeanUtils.copyProperties(accountMasterRequest, accountMaster);
				accountMaster.setCreatedDate(new Date());
				accountMaster.setModifiedDate(new Date());
				accountMaster.setIsActive(true);

				accountMasterRepository.save(accountMaster);
				return true;

			}
			case 2: {
				AddressMasterRequest addressMasterRequest = new AddressMasterRequest();
				addressMasterRequest = (AddressMasterRequest) MultipleJSONObjectHelper
						.getObjectFromMap((Map<String, Object>) request.getMaster(), AddressMasterRequest.class);

				AddressMaster addressMaster = new AddressMaster();
				BeanUtils.copyProperties(addressMasterRequest, addressMaster);
				addressMaster.setCreatedDate(new Date());
				addressMaster.setModifiedDate(new Date());
				addressMaster.setIsActive(true);

				addressMasterRepository.save(addressMaster);
				return true;
			}
			case 3: {
				CategoryMasterRequest categoryMasterRequest = new CategoryMasterRequest();
				categoryMasterRequest = (CategoryMasterRequest) MultipleJSONObjectHelper
						.getObjectFromMap((Map<String, Object>) request.getMaster(), CategoryMasterRequest.class);

				CategoryMaster categoryMaster = new CategoryMaster();
				BeanUtils.copyProperties(categoryMasterRequest, categoryMaster);
				categoryMaster.setCreatedDate(new Date());
				categoryMaster.setModifiedDate(new Date());
				categoryMaster.setIsActive(true);

				categoryMasterRepository.save(categoryMaster);
				return true;
			}
			case 4: {
				CompanyMasterRequest companyMasterRequest = new CompanyMasterRequest();
				companyMasterRequest = (CompanyMasterRequest) MultipleJSONObjectHelper
						.getObjectFromMap((Map<String, Object>) request.getMaster(), CompanyMasterRequest.class);

				CompanyMaster companyMaster = new CompanyMaster();
				BeanUtils.copyProperties(companyMasterRequest, companyMaster);
				companyMaster.setCreatedDate(new Date());
				companyMaster.setModifiedDate(new Date());
				companyMaster.setIsActive(true);

				companyMasterRepository.save(companyMaster);
				return true;
			}
			case 5: {
				CustomerMasterRequest customerMasterRequest = new CustomerMasterRequest();
				customerMasterRequest = (CustomerMasterRequest) MultipleJSONObjectHelper
						.getObjectFromMap((Map<String, Object>) request.getMaster(), CustomerMasterRequest.class);

				CustomerMaster customerMaster = new CustomerMaster();
				BeanUtils.copyProperties(customerMasterRequest, customerMaster);
				customerMaster.setCreatedDate(new Date());
				customerMaster.setModifiedDate(new Date());
				customerMaster.setIsActive(true);

				customerMasterRepository.save(customerMaster);
				return true;
			}
			case 6: {
				ProductMasterRequest productMasterRequest = new ProductMasterRequest();
				productMasterRequest = (ProductMasterRequest) MultipleJSONObjectHelper
						.getObjectFromMap((Map<String, Object>) request.getMaster(), ProductMasterRequest.class);

				ProductMaster productMaster= new ProductMaster();
				BeanUtils.copyProperties(productMasterRequest, productMaster);
				productMaster.setCreatedDate(new Date());
				productMaster.setModifiedDate(new Date());
				productMaster.setIsActive(true);

				productMasterRepository.save(productMaster);
				return true;
			}
			case 7: {
				RouteMasterRequest routeMasterRequest = new RouteMasterRequest();
				routeMasterRequest = (RouteMasterRequest) MultipleJSONObjectHelper
						.getObjectFromMap((Map<String, Object>) request.getMaster(), RouteMasterRequest.class);

				RouteMaster routeMaster= new RouteMaster();
				BeanUtils.copyProperties(routeMasterRequest, routeMaster);
				routeMaster.setCreatedDate(new Date());
				routeMaster.setModifiedDate(new Date());
				routeMaster.setIsActive(true);

				routeMasterRepository.save(routeMaster);
				return true;
			}
			}
		} catch (Exception e) {
			return false;
		}

		return null;
	}
}
